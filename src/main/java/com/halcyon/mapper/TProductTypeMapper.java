package com.halcyon.mapper;

import com.halcyon.entity.TProductType;

import java.util.List;

public interface TProductTypeMapper {
    int deleteByPrimaryKey(Integer ttId);

    int insert(TProductType record);

    int insertSelective(TProductType record);

    TProductType selectByPrimaryKey(Integer ttId);

    int updateByPrimaryKeySelective(TProductType record);

    int updateByPrimaryKey(TProductType record);

    List<String> getAllTid();
}