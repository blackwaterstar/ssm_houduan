package com.qf.service;

import com.qf.entity.dto.CreateOrderDTO;
import com.qf.entity.dto.OrderDTO;
import com.qf.entity.dto.ResultDTO;
import com.qf.entity.vo.OrderVO;

import java.util.List;

public interface IOrderService {

    void addOrder(OrderVO orderVO);

    ResultDTO addOrder(OrderDTO orderDTO);

    List<CreateOrderDTO> getList(Long userId);
}
