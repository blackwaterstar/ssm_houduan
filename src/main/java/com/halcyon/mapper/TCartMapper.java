package com.halcyon.mapper;

import com.halcyon.entity.TCart;
import com.halcyon.entity.vo.CartVO;

import java.util.List;

public interface TCartMapper {
    int deleteByPrimaryKey(Long tcId);

    int insert(TCart record);

    int insertSelective(TCart record);

    TCart selectByPrimaryKey(Long tcId);

    int updateByPrimaryKeySelective(TCart record);

    int updateByPrimaryKey(TCart record);

    List<TCart> selectByUserId(Long userId);

    List<CartVO> selectCartVOByUserId(Long userId);
}
