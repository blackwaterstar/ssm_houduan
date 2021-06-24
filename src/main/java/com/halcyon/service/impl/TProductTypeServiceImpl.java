package com.halcyon.service.impl;

import com.halcyon.entity.TProduct;
import com.halcyon.entity.TProductType;
import com.halcyon.mapper.TProductTypeMapper;
import com.halcyon.service.TProductTypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TProductTypeServiceImpl implements TProductTypeService{

    @Autowired
    private TProductTypeMapper tProductTypeMapper;

    @Override
    public List<TProductType> getAllTid() {
        return tProductTypeMapper.getAllTid();
    }

    @Override
    public List<TProductType> queryTwPage(Integer startRows) {
        return tProductTypeMapper.queryTwPage(startRows);
    }

    @Override
    public List<TProductType> selectTwPage(String tname, String tid, Integer startRows) {
        return tProductTypeMapper.selectTwPage(tname, tid,startRows);
    }

    @Override
    public Integer getRowCount(String pname, String tid) {
        return tProductTypeMapper.getRowCount(pname,tid);
    }

    @Override
    public Integer createTw(TProductType tproduct) {
        return tProductTypeMapper.createTw(tproduct);
    }

    @Override
    public Integer deleteTwById(String twId) {
        return tProductTypeMapper.deleteTwById(twId);
    }

    @Override
    public Integer deleteTwByIdList(@Param("list")List twIds) {
        return tProductTypeMapper.deleteTwByIdList(twIds);
    }

    @Override
    public Integer updateTwById(TProductType tproduct) {
        return tProductTypeMapper.updateTwById(tproduct);
    }
}
