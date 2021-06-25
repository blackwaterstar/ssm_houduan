package com.halcyon.controller;

import com.halcyon.entity.TUserWallet;
import com.halcyon.service.IUserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("userwallet")
public class UserWalletController {

    @Autowired
    private IUserWalletService userWalletService;

    @ResponseBody
    @RequestMapping("wallet")
    public TUserWallet getTUserWallet(Long userId){
      return  userWalletService.getTUserWallet(userId);

    }
    @ResponseBody
    @RequestMapping("paymoney")
    public void paymoney(Long userId,Long orderId,Long orderPrice){
          userWalletService.paymoney(userId,orderId,orderPrice);

    }

}
