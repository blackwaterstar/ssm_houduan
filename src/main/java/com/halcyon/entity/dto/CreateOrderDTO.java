package com.halcyon.entity.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class CreateOrderDTO {

    /*
    订单的创建时间
    订单编号
    订单总金额

    商品集合：
        商品名称
        商品价格
        商品数量
     */

    private Date createdTime;
    private Long orderId;
    private BigDecimal orderPrice;

    private List<OrderProductDTO> products;


}
