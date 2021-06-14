package com.qf.controller;

import com.qf.entity.TUserWallet;
import com.qf.service.IUserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userwallet")
public class UserWalletController {

    @Autowired
    private IUserWalletService userWalletService;

    @RequestMapping("wallet")
    public TUserWallet getTUserWallet(Long userId){
      return  userWalletService.getTUserWallet(userId);

    }

}
