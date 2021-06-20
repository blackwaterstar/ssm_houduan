package com.halcyon.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProductDTO {

     /*
    订单的创建时间
    订单编号
    订单总金额

    商品集合：
        商品名称
        商品价格
        商品数量
     */

     private String pname;
     private BigDecimal price;
     private Long pcount;

}
