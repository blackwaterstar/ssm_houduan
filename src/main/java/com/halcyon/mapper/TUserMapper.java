package com.halcyon.mapper;

import com.halcyon.entity.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TUserMapper {
    int deleteByPrimaryKey(Long tuId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long tuId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    TUser selectByTelAndPwd(Map<String, String> map);

    String register(TUser user);
    /**
     * 分页查询 User
     * @param startRows 起始页
     * @return List<User>
     */
    List<TUser> queryUserPage(Integer startRows);

    /**
     * 分页查询 User 带条件
     * @param userId
     * @param userNickname
     * @param startRows
     * @return
     */
    List<TUser> selectUserPage(@Param("userId")String userId, @Param("userNickname")String userNickname, @Param("startRows")Integer startRows);

    /**
     * 查询 User 个数
     * @param userId
     * @param userNickname
     * @return
     */
    Integer getRowCount(@Param("userId")String userId, @Param("userNickname")String userNickname);

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
     * @param tuIds
     * @return
     */
    Integer deleteUserByIdList(@Param("list") List tuIds);

    /**
     * 根据 userId 更新用户
     * @return 返回码
     */
    Integer updateUserById(TUser user);
}
