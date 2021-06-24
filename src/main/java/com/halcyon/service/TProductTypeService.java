package com.halcyon.service;

import com.halcyon.entity.TProduct;
import com.halcyon.entity.TProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TProductTypeService {
    List<TProductType> getAllTid();
    /**
     * 分页查询
     */
    List<TProductType> queryTwPage(Integer startRows);

    /**
     * 分页查询 带条件
     * @return
     */
    List<TProductType> selectTwPage(String tname,String tid, Integer startRows);

    /**
     * 查询  个数
     */
    Integer getRowCount(String pname, String tid);

    /**
     * 添加
     */
    Integer createTw(TProductType tProductType);

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
    Integer updateTwById(TProductType tProductType);
}
