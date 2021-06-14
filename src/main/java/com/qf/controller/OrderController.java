package com.qf.controller;

import com.qf.entity.dto.CreateOrderDTO;
import com.qf.entity.dto.OrderDTO;
import com.qf.entity.dto.ResultDTO;
import com.qf.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;


    @RequestMapping("addOrder")
    public ResultDTO addOrder(OrderDTO orderDTO){
//        System.out.println(orderDTO);

        return  orderService.addOrder(orderDTO);

    }


    /**
     * 获取当前用户的所有订单
     * @param userId
     * @return
     */
    @RequestMapping("list")
    public List<CreateOrderDTO> getList(Long userId){

        return orderService.getList(userId);


    }


}
