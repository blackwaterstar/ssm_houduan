package com.qf.mapper;

import com.qf.entity.TProduct;

import java.util.List;

public interface TProductMapper {
    int deleteByPrimaryKey(Long tpId);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    TProduct selectByPrimaryKey(Long tpId);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKey(TProduct record);

    List<TProduct> list();

    TProduct selectByPid(Long pid);

    List<TProduct> selectByPids(List<Long> pids);
}
