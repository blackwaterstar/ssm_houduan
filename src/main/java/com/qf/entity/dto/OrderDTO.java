package com.qf.entity.dto;

import java.util.List;

/**
 * 存放提交订单时的请求参数
 */
public class OrderDTO {

    private Long userId;
    private Long orderPrice;
    private String orderUser;
    private String orderTel;
    private String orderAddr;
    private List<Long> pids;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }

    public List<Long> getPids() {
        return pids;
    }

    public void setPids(List<Long> pids) {
        this.pids = pids;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "userId=" + userId +
                ", orderPrice=" + orderPrice +
                ", orderUser='" + orderUser + '\'' +
                ", orderTel='" + orderTel + '\'' +
                ", orderAddr='" + orderAddr + '\'' +
                ", pids=" + pids +
                '}';
    }
}
