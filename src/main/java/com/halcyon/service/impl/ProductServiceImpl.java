package com.halcyon.service.impl;

import com.halcyon.entity.TProduct;
import com.halcyon.mapper.TProductMapper;
import com.halcyon.service.IProductService;
import org.apache.ibatis.annotations.Param;
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


    @Override
    public List<TProduct> queryTwPage(Integer startRows) {
        return tProductMapper.queryTwPage(startRows);
    }

    @Override
    public List<TProduct> selectTwPage(String pname, String tid, Integer startRows) {
        return tProductMapper.selectTwPage(pname, tid,startRows);
    }

    @Override
    public Integer getRowCount(String pname, String tid) {
        return tProductMapper.getRowCount(pname,tid);
    }

    @Override
    public Integer createTw(TProduct tproduct) {
        return tProductMapper.createTw(tproduct);
    }

    @Override
    public Integer deleteTwById(String twId) {
        return tProductMapper.deleteTwById(twId);
    }

    @Override
    public Integer deleteTwByIdList(@Param("list")List twIds) {
        return tProductMapper.deleteTwByIdList(twIds);
    }

    @Override
    public Integer updateTwById(TProduct tproduct) {
        return tProductMapper.updateTwById(tproduct);
    }
}
