package com.halcyon.service.impl;

import com.halcyon.entity.TWarehouse;
import com.halcyon.mapper.TWarehouseMapper;
import com.halcyon.service.IwarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements IwarehouseService {

    @Autowired
    private TWarehouseMapper tWarehouseMapper;

    @Override
    public List<TWarehouse> queryTwPage(Integer startRows) {
        return tWarehouseMapper.queryTwPage(startRows);
    }

    @Override
    public List<TWarehouse> selectTwPage(String tid, String pid, Integer startRows) {
        return tWarehouseMapper.selectTwPage(tid,pid,startRows);
    }

    @Override
    public Integer getRowCount(String tid, String pid) {
        return tWarehouseMapper.getRowCount(tid,pid);
    }

    @Override
    public Integer createTw(TWarehouse tWarehouse) {
        return tWarehouseMapper.createTw(tWarehouse);
    }

    @Override
    public Integer deleteTwById(String twId) {
        return tWarehouseMapper.deleteTwById(twId);
    }

    @Override
    public Integer deleteTwByIdList(List twIds) {
        return tWarehouseMapper.deleteTwByIdList(twIds);
    }

    @Override
    public Integer updateTwById(TWarehouse tWarehouse) {
        return tWarehouseMapper.updateTwById(tWarehouse);
    }
}
