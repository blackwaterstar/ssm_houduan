package com.halcyon.entity.vo;

import com.halcyon.entity.TOrder;
import com.halcyon.entity.TProduct;
import lombok.Data;

import java.util.List;

/**
 * 跟订单相关的数据实体
 */
@Data
public class OrderVO {

    private TOrder tOrder;

    //当前订单所有商品的集合
    private List<TProduct> products;


}
