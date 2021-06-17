package com.halcyon.service.impl;

import com.halcyon.entity.TOrderinfo;
import com.halcyon.mapper.TOrderinfoMapper;
import com.halcyon.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements IOrderInfoService {

    @Autowired
    TOrderinfoMapper orderinfoMapper;


    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void addOrderInfo(List<TOrderinfo> orderinfos) throws Exception {

        if(orderinfos.isEmpty() || orderinfos==null) {
           throw new NullPointerException();
        }

        orderinfoMapper.insertOrderInfos(orderinfos);
    }

    @Override
    public List<TOrderinfo> getOrderInfosByOrderId(Long orderId) {
        return orderinfoMapper.selectByOrderId(orderId);
    }
}
