package com.qf.mapper;

import com.qf.entity.TCart;
import com.qf.entity.vo.CartVO;

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
