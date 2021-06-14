package com.qf.service;

import com.qf.entity.TOrderinfo;

import java.util.List;

public interface IOrderInfoService {
//    void addOrderInfo(TOrderinfo orderinfo);

    /**
     * 因为一个订单会有多个商品
     * 将多条记录添加到订单详情表中。
     * @param orderinfos
     */
    void addOrderInfo(List<TOrderinfo> orderinfos) throws Exception;


    List<TOrderinfo> getOrderInfosByOrderId(Long orderId);
}
