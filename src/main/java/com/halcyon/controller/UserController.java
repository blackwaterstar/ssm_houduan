package com.halcyon.controller;

import com.halcyon.entity.TUser;
import com.halcyon.entity.dto.ResultDTO;
import com.halcyon.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;


    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResultDTO login(String userTel, String userPwd) {

        return userService.login(userTel, userPwd);

    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(TUser user) {
        return userService.register(user);
    }


}
