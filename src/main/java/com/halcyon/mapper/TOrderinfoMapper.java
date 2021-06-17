package com.halcyon.mapper;

import com.halcyon.entity.TOrderinfo;

import java.util.List;

public interface TOrderinfoMapper {
    int deleteByPrimaryKey(Long toiId);

    int insert(TOrderinfo record);

    int insertSelective(TOrderinfo record);

    TOrderinfo selectByPrimaryKey(Long toiId);

    int updateByPrimaryKeySelective(TOrderinfo record);

    int updateByPrimaryKey(TOrderinfo record);

    void insertOrderInfos(List<TOrderinfo> orderinfos);

    List<TOrderinfo> selectByOrderId(Long orderId);
}
