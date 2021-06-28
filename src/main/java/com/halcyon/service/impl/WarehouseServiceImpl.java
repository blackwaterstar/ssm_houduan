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
    public List<TWarehouse> selectTwPage(String pname, String tid, Integer startRows) {
        return tWarehouseMapper.selectTwPage(pname, tid,startRows);
    }
    @Override
    public List<TWarehouse> selectTwPage1(String pname, String tid) {
        return tWarehouseMapper.selectTwPage1(pname, tid);
    }

    @Override
    public Integer getRowCount(String pname, String tid) {
        return tWarehouseMapper.getRowCount(pname,tid);
    }

    @Override
    public Integer createTw(TWarehouse tWarehouse) {
        tWarehouse.setPshelf("未上架");
        return tWarehouseMapper.createTw(tWarehouse);
    }

    @Override
    public List<TWarehouse> queryTwPage1() {
        return tWarehouseMapper.queryTwPage1();
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
