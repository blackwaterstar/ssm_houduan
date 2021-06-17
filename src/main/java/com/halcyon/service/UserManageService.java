package com.halcyon.service;

import com.halcyon.entity.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserManageService {


    /**
     * 分页查询 User
     * @param startRows 起始页
     * @return List<User>
     */
    List<TUser> queryUserPage(Integer startRows);

    /**
     * 分页查询 User 带条件
     * @param userName
     * @param userSex
     * @param startRows
     * @return
     */
    List<TUser> selectUserPage(@Param("userName")String userName, @Param("userSex")String userSex, @Param("startRows")Integer startRows);

    /**
     * 查询 User 个数
     * @param userName
     * @param userSex
     * @return
     */
    Integer getRowCount(@Param("userName")String userName, @Param("userSex")String userSex);

    /**
     * 添加 User
     * @param user
     * @return 返回码
     */
    Integer createUser(TUser user);

    /**
     * 根据 userId 删除用户
     * @return 返回码
     */
    Integer deleteUserById(String userId);

    /**
     * 根据 userId 批量删除用户
     * @param userIds
     * @return
     */
    Integer deleteUserByIdList(@Param("list") List userIds);

    /**
     * 根据 userId 更新用户
     * @return 返回码
     */
    Integer updateUserById(TUser user);

}
