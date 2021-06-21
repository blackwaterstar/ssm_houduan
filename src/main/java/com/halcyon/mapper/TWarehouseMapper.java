package com.halcyon.mapper;


import com.halcyon.entity.TWarehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TWarehouseMapper {
    int deleteByPrimaryKey(Long twId);

    int insert(TWarehouse record);

    int insertSelective(TWarehouse record);

    TWarehouse selectByPrimaryKey(Long twId);

    int updateByPrimaryKeySelective(TWarehouse record);

    int updateByPrimaryKey(TWarehouse record);


    /**
     * 分页查询
     */
    List<TWarehouse> queryTwPage(Integer startRows);

    /**
     * 分页查询 带条件
     * @return
     */
    List<TWarehouse> selectTwPage(@Param("tid")String tid, @Param("pid")String pid, @Param("startRows")Integer startRows);

    /**
     * 查询  个数
     */
    Integer getRowCount(@Param("tid")String tid, @Param("pid")String pid);

    /**
     * 添加
     */
    Integer createTw(TWarehouse tWarehouse);

    /**
     * 根据 Id 删除

     */
    Integer deleteTwById(String twId);

    /**
     * 根据 Id 批量删除用户
     */
    Integer deleteTwByIdList(@Param("list") List twId);

    /**
     * 根据 Id 更新
     */
    Integer updateTwById(TWarehouse tWarehouse);
}