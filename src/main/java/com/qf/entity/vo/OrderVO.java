package com.qf.entity.vo;

import com.qf.entity.TOrder;
import com.qf.entity.TProduct;

import java.util.List;

/**
 * 跟订单相关的数据实体
 */
public class OrderVO {

    private TOrder tOrder;

    //当前订单所有商品的集合
    private List<TProduct> products;

    public TOrder gettOrder() {
        return tOrder;
    }

    public void settOrder(TOrder tOrder) {
        this.tOrder = tOrder;
    }

    public List<TProduct> getProducts() {
        return products;
    }

    public void setProducts(List<TProduct> products) {
        this.products = products;
    }
}
