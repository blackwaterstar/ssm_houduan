package com.halcyon.mapper;

import com.halcyon.entity.TOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrderMapper {
    int deleteByPrimaryKey(Long toId);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    Integer updatestatme(@Param("orderId")Long orderId);

    TOrder selectByPrimaryKey(Long toId);
    TOrder selectByPrimaryKey1(@Param("orderId") Long orderId);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
    int updateByPrimaryKey1(TOrder record);

    List<TOrder> selectByUserId(Long userId);
    List<TOrder> selectByUserId1(Long userId);

    List<TOrder> selectByUserId2(@Param("orderId") Long orderId, @Param("userId") Long userId);
}
