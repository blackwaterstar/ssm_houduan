package com.halcyon.mapper;

import com.halcyon.entity.TProduct;
import com.halcyon.entity.TProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TProductTypeMapper {
    int deleteByPrimaryKey(Integer ttId);

    int insert(TProductType record);

    int insertSelective(TProductType record);

    TProductType selectByPrimaryKey(Integer ttId);

    int updateByPrimaryKeySelective(TProductType record);

    int updateByPrimaryKey(TProductType record);

    List<TProductType> getAllTid();

    /**
     * 分页查询
     */
    List<TProductType> queryTwPage(Integer startRows);

    /**
     * 分页查询 带条件
     * @return
     */
    List<TProductType> selectTwPage(@Param("tname")String tname, @Param("tid")String tid, @Param("startRows")Integer startRows);
    List<TProductType> selectTwPage1(@Param("tname")String tname, @Param("tid")String tid);
    /**
     * 查询  个数
     */
    Integer getRowCount(@Param("tname")String tname, @Param("tid")String tid);

    /**
     * 添加
     */
    Integer createTw(TProductType tProduct);

    /**
     * 根据 Id 删除

     */
    Integer deleteTwById(String tpId);

    /**
     * 根据 Id 批量删除用户
     */
    Integer deleteTwByIdList(@Param("list") List tpId);

    /**
     * 根据 Id 更新
     */
    Integer updateTwById(TProductType tProduct);
}