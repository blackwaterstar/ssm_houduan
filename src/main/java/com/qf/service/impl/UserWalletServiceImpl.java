package com.qf.service.impl;

import com.qf.entity.TUserWallet;
import com.qf.mapper.TUserWalletMapper;
import com.qf.service.IUserWalletService;
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
