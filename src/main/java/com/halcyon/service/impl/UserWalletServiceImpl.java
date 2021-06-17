package com.halcyon.service.impl;

import com.halcyon.entity.TUserWallet;
import com.halcyon.mapper.TUserWalletMapper;
import com.halcyon.service.IUserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWalletServiceImpl implements IUserWalletService {

    @Autowired
    private TUserWalletMapper dao;

    @Override
    public TUserWallet getTUserWallet(Long userId) {
        return dao.selectByUserId(userId);
    }
}
