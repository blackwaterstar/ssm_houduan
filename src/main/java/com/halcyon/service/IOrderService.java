package com.halcyon.service;

import com.halcyon.entity.TOrder;
import com.halcyon.entity.dto.CreateOrderDTO;
import com.halcyon.entity.dto.OrderDTO;
import com.halcyon.entity.dto.ResultDTO;
import com.halcyon.entity.vo.OrderVO;

import java.util.List;

public interface IOrderService {

    void addOrder(OrderVO orderVO);

    ResultDTO addOrder(OrderDTO orderDTO);

    List<CreateOrderDTO> getList(Long userId);
    List<CreateOrderDTO> getList1(Long userId);

    List<CreateOrderDTO> getList2(Long orderId, Long userId);

    TOrder getorder(Long orderId);

    Integer updatestatme(Long orderId);
}
