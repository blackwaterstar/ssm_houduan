package com.qf.controller;

import com.qf.entity.dto.ResultDTO;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public ResultDTO login(String userTel, String userPwd) {

        return userService.login(userTel, userPwd);


    }


}
