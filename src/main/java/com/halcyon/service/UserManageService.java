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

    List<TUser> selectUserPage(String userName, String userSex,Integer startRows);

    List<TUser> selectUserPage1(String userId, String userNickname);


    Integer getRowCount(String userId,String userNickname);

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
