package com.halcyon.controller;

import com.halcyon.entity.TOrder;
import com.halcyon.entity.dto.CreateOrderDTO;
import com.halcyon.entity.dto.OrderDTO;
import com.halcyon.entity.dto.ResultDTO;
import com.halcyon.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;


    @ResponseBody
    @RequestMapping("addOrder")
    public ResultDTO addOrder(OrderDTO orderDTO){
        System.out.println(orderDTO);

        return  orderService.addOrder(orderDTO);

    }

    /**
     * 获取当前用户的所有订单
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("list")
    public List<CreateOrderDTO> getList(Long userId){
        return orderService.getList(userId);
    }

    /**
     * 获取当前用户的所有订单
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("list1")
    public List<CreateOrderDTO> getList1(Long userId){
        return orderService.getList(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/list2",method = RequestMethod.POST)
    public List<CreateOrderDTO> getList2(Long orderId,Long userId){
        return orderService.getList2(orderId,userId);
    }


    @ResponseBody
    @RequestMapping(value = "/getOrder",method = RequestMethod.POST)
    public TOrder getOrder(Long orderId){
        return orderService.getorder(orderId);
    }

    @ResponseBody
    @RequestMapping(value = "/updatestatme",method = RequestMethod.POST)
    public Integer updatestatme(Long orderId){
        return orderService.updatestatme(orderId);
    }



}
