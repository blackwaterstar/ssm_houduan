package com.qf.mapper;

import com.qf.entity.TOrder;

import java.util.List;

public interface TOrderMapper {
    int deleteByPrimaryKey(Long toId);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Long toId);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);


    List<TOrder> selectByUserId(Long userId);
}
