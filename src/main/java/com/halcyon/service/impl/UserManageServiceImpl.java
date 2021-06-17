package com.halcyon.service.impl;

import com.halcyon.entity.TUser;
import com.halcyon.mapper.TUserMapper;
import com.halcyon.service.UserManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManageServiceImpl implements UserManageService {


    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public List<TUser> queryUserPage(Integer startRows) {
        return tUserMapper.queryUserPage(startRows);
    }

    @Override
    public List<TUser> selectUserPage(String userName, String userSex, Integer startRows) {
        return tUserMapper.selectUserPage(userName, userSex, startRows);
    }

    @Override
    public Integer getRowCount(String userName, String userSex) {
        return tUserMapper.getRowCount(userName, userSex);
    }

    @Override
    public Integer createUser(TUser user) {
        return tUserMapper.createUser(user);
    }

    @Override
    public Integer deleteUserById(String userId) {
        return tUserMapper.deleteUserById(userId);
    }

    @Override
    public Integer deleteUserByIdList(@Param("list") List userIds) {
        return tUserMapper.deleteUserByIdList(userIds);
    }

    @Override
    public Integer updateUserById(TUser user) {
        return tUserMapper.updateUserById(user);
    }
}
