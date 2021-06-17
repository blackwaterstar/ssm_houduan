package com.halcyon.mapper;

import com.halcyon.entity.TUserAddr;

public interface TUserAddrMapper {
    int deleteByPrimaryKey(Long tuaId);

    int insert(TUserAddr record);

    int insertSelective(TUserAddr record);

    TUserAddr selectByPrimaryKey(Long tuaId);

    int updateByPrimaryKeySelective(TUserAddr record);

    int updateByPrimaryKey(TUserAddr record);
}