package com.halcyon.service;

import com.halcyon.entity.TProduct;
import com.halcyon.entity.TWarehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductService {

    void addProduct(TProduct product);

    List<TProduct> getProducts();


    TProduct getProductById(Long pid);

    List<TProduct> selectByPids(List<Long> pids);
    /**
     * 分页查询
     */
    List<TProduct> queryTwPage(Integer startRows);

    /**
     * 分页查询 带条件
     * @return
     */
    List<TProduct> selectTwPage(String tid,String pid, Integer startRows);

    /**
     * 查询  个数
     */
    Integer getRowCount(String pname, String tid);

    /**
     * 添加
     */
    Integer createTw(TProduct tProduct);

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
    Integer updateTwById(TProduct tProduct);
}
