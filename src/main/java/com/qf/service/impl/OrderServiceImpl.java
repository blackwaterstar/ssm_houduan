package com.qf.service.impl;

import com.qf.common.util.MyUtil;
import com.qf.entity.TOrder;
import com.qf.entity.TOrderinfo;
import com.qf.entity.TProduct;
import com.qf.entity.dto.CreateOrderDTO;
import com.qf.entity.dto.OrderDTO;
import com.qf.entity.dto.OrderProductDTO;
import com.qf.entity.dto.ResultDTO;
import com.qf.entity.vo.OrderVO;
import com.qf.mapper.TOrderMapper;
import com.qf.service.IOrderInfoService;
import com.qf.service.IOrderService;
import com.qf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {


    @Autowired
    private TOrderMapper tOrderMapper;

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderInfoService orderInfoService;

    /**
     * TOrder
     * List<Product>
     *
     *  往订单表里填数据
     *  往订单详情表里填数据
     *  往已售商品表里填数据
     *
     * @param orderVO
     */
    @Transactional(rollbackFor = Exception.class)  //方法A
    public void addOrder(OrderVO orderVO) {
        //从orderVO中获得order对象
        TOrder order = orderVO.gettOrder();
        //从orderVO中获得所有商品的集合
        List<TProduct> products = orderVO.getProducts();
        //将order存到数据库的订单表里
        tOrderMapper.insert(order);
        //====================

        //将数据存入到订单详情表中
        //需要封装一个List<TOrderinfo>
        //将List<TProduct>==> List<TOrderinfo>
        //1.遍历
        Iterator<TProduct> iterator = products.iterator();
        List<TOrderinfo> list = new ArrayList<TOrderinfo>();
        Long orderId = order.getOrderId();
        while(iterator.hasNext()){
            TProduct product = iterator.next();
            TOrderinfo tOrderinfo = new TOrderinfo();
            tOrderinfo.setOrderId(orderId);
            tOrderinfo.setProId(product.getPid());
            list.add(tOrderinfo);
        }
        //得到List
        //调用service实现订单详情列表的插入
//        try {
//            orderInfoService.addOrderInfo(list); //方法B
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            orderInfoService.addOrderInfo(list); //方法B  出现了异常
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 收到一个OrderDTO,转换成OrderVO，再调用addOrder
     * @param orderDTO
     */
    public ResultDTO addOrder(OrderDTO orderDTO) {

        ResultDTO resultDTO = new ResultDTO();
        try {
            //1.封装OrderVO中的TOrder
            OrderVO orderVO = new OrderVO();

            TOrder tOrder = new TOrder();

            tOrder.setOrderId(MyUtil.getCurrentTimeForId());
            tOrder.setUserId(orderDTO.getUserId());
            tOrder.setOrderUser(orderDTO.getOrderUser());
            tOrder.setOrderTel(orderDTO.getOrderTel());
            tOrder.setOrderAddr(orderDTO.getOrderAddr());
            tOrder.setOrderFlag((short)1);
            tOrder.setOrderPrice(orderDTO.getOrderPrice());
            tOrder.setCreatedTime(new Date());
            tOrder.setUpdatedTime(new Date());

            orderVO.settOrder(tOrder);
            //2.封装OrderVO中的List<Products>
//        orderVO.setProducts();
            List<Long> pids = orderDTO.getPids();
            //根据商品id集合获得相应的商品集合
            List<TProduct> products = productService.selectByPids(pids);

            orderVO.setProducts(products);

            //=======开心！！！！=======


            addOrder(orderVO);




            resultDTO.setResult(true);
            resultDTO.setMessage("下单成功");


        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setResult(false);
            resultDTO.setMessage("你点背，下单失败");
        }


        return resultDTO;
    }

    /**
     * 获取当前用户的所有订单
     *
     * @param userId
     * @return
     */
    public List<CreateOrderDTO> getList(Long userId) {

        /*
    订单的创建时间
    订单编号
    订单总金额

    商品集合：
        商品名称
        商品价格
        商品数量
     */
        List<TOrder> orders = tOrderMapper.selectByUserId(userId);


        List<CreateOrderDTO> cods = new ArrayList<CreateOrderDTO>();

        orders.forEach( order -> {
            CreateOrderDTO cod = new CreateOrderDTO();
            cod.setCreatedTime(order.getCreatedTime());
            cod.setOrderId(order.getOrderId());
            BigDecimal bd = new BigDecimal(order.getOrderPrice().longValue());
            cod.setOrderPrice(bd);
            //将cod存入到cods集合中
            cods.add(cod);
        });

        //遍历cods
        //根据订单编号，去订单详情表中获取该订单的所欲商品的id及商品数量
        //还要根据商品的id取商品表里获取商品名称和商品价格

        cods.forEach( cod->{
            //根据订单编号，去订单详情表中获取该订单的所有商品的id及商品数量
             List<TOrderinfo> orderinfos =  orderInfoService.getOrderInfosByOrderId(cod.getOrderId());
             //封装OrderProductDTO
            List<OrderProductDTO> opds = new ArrayList<>();
            orderinfos.forEach(orderinfo ->{
                //通过商品id封装OrderProductDTO
                OrderProductDTO opd = getOrderProductDTO(orderinfo.getProId());
                //从orderinfo中获取商品数量存入到opd中
                opd.setPcount(orderinfo.getPcount());
                //opd封装完毕
                //存入到集合中
                opds.add(opd);
            });

            //将商品集合存入到CreateOrderDTO对象中
            cod.setProducts(opds);


//            getOrderProductDTO()

        });



        return cods;
    }

    /**
     * 根据商品id，去数据库获取该商品的信息，并封装成OrderProductDTO对象
     * @param proId
     * @return
     */
    private OrderProductDTO getOrderProductDTO(Long proId) {
        OrderProductDTO opd = new OrderProductDTO();
        TProduct product = productService.getProductById(proId);
        opd.setPname(product.getPname());
        opd.setPrice(new BigDecimal(product.getPrice().longValue()));
        return opd;

    }


}
