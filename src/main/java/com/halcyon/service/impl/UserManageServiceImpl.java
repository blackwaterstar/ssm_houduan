package com.halcyon.service.impl;

import com.halcyon.entity.TUser;
import com.halcyon.entity.TUserWallet;
import com.halcyon.mapper.TUserMapper;
import com.halcyon.mapper.TUserWalletMapper;
import com.halcyon.service.UserManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserManageServiceImpl implements UserManageService {


    @Autowired
    private TUserMapper tUserMapper;
    @Autowired
    private TUserWalletMapper tUserWalletMapper;

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
    @Transactional(rollbackFor = Exception.class)
    public Integer createUser(TUser user) {
        TUserWallet tUserWallet = new TUserWallet();
        tUserWallet.setUserId(Long.valueOf(user.getUserId()));
        tUserWallet.setUserAmount(Long.valueOf(0));
        tUserWalletMapper.insert(tUserWallet);
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
