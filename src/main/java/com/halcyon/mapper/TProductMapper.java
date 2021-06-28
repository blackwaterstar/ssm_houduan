package com.halcyon.mapper;

import com.halcyon.entity.TProduct;
import com.halcyon.entity.TWarehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TProductMapper {
    int deleteByPrimaryKey(Long tpId);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    TProduct selectByPrimaryKey(Long tpId);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKey(TProduct record);

    List<TProduct> list();
    List<TProduct> list1(@Param("tid")String tid,@Param("pname")String pname);

    TProduct selectByPid(Long pid);

    List<TProduct> selectByPids(List<Long> pids);
    /**
     * 分页查询
     */
    List<TProduct> queryTwPage(Integer startRows);

    /**
     * 分页查询 带条件
     * @return
     */
    List<TProduct> selectTwPage(@Param("pname")String pname, @Param("tid")String tid, @Param("startRows")Integer startRows);

    /**
     * 查询  个数
     */
    Integer getRowCount(@Param("pname")String pname, @Param("tid")String tid);

    /**
     * 添加
     */
    Integer createTw(TProduct tProduct);

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
    Integer updateTwById(TProduct tProduct);
}
