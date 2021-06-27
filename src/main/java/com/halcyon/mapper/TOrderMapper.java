package com.halcyon.mapper;

import com.halcyon.entity.TOrder;

import java.util.List;

public interface TOrderMapper {
    int deleteByPrimaryKey(Long toId);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Long toId);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
    int updateByPrimaryKey1(TOrder record);

    List<TOrder> selectByUserId(Long userId);
    List<TOrder> selectByUserId1(Long userId);
}
