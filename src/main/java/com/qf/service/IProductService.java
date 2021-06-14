package com.qf.service;

import com.qf.entity.TProduct;

import java.util.List;

public interface IProductService {

    void addProduct(TProduct product);

    List<TProduct> getProducts();


    TProduct getProductById(Long pid);

    List<TProduct> selectByPids(List<Long> pids);
}
