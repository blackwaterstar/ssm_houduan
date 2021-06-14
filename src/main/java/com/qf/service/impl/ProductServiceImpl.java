package com.qf.service.impl;

import com.qf.entity.TProduct;
import com.qf.mapper.TProductMapper;
import com.qf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    TProductMapper tProductMapper;

    public void addProduct(TProduct product) {
        tProductMapper.insert(product);
    }

    public List<TProduct> getProducts() {
        return tProductMapper.list();
    }

    public TProduct getProductById(Long pid) {
        return tProductMapper.selectByPid(pid);
    }

    @Override
    public List<TProduct> selectByPids(List<Long> pids) {
        return tProductMapper.selectByPids(pids);
    }
}
