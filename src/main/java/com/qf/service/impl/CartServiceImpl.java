package com.qf.service.impl;

import com.qf.common.util.MyUtil;
import com.qf.entity.TCart;
import com.qf.entity.vo.CartVO;
import com.qf.mapper.TCartMapper;
import com.qf.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private TCartMapper cartMapper;

    public List<TCart> getAllCarts(Long userId) {
        return cartMapper.selectByUserId(userId);
    }

    public List<CartVO> getCartVOList(Long userId){

        return cartMapper.selectCartVOByUserId(userId);

    }

    public List<CartVO> list(Long userId, Long pid, Long pcount) {
        //1.获取所有的购物车信息
        List<TCart> carts = getAllCarts(userId);


        //2.更新购物车表
        boolean b = true;
        for (TCart cart : carts) {
            //如果商品已存在，让已存在的商品的数量改变，并更新进数据库中。
            if(cart.getPid().equals(pid)){
                cart.setPcount(cart.getPcount()+pcount);
                cartMapper.updateByPrimaryKey(cart);
                b = false;
            }
        }
        //如果商品不存在。则添加新的记录
        if(b){
            //封装tcart
            TCart tCart = new TCart();
            tCart.setUserId(userId);
            tCart.setPcount(pcount);
            tCart.setCartId(MyUtil.getCurrentTimeForId());
            tCart.setPid(pid);
            //存到数据库里
            cartMapper.insert(tCart);

        }
        //获取当前购车的CartVO集合
        return getCartVOList(userId);

    }


}
