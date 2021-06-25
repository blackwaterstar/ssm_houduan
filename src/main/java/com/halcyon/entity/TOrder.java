package com.halcyon.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TOrder {
    private Long toId;

    private Long orderId;

    private Long userId;

    private Long orderPrice;

    private Short orderFlag;

    private String orderUser;

    private String orderTel;

    private String orderAddr;

    private Date createdTime;

    private Date updatedTime;

    private String paystatue;


}
