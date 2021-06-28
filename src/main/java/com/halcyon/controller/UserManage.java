package com.halcyon.controller;

import com.halcyon.entity.TUser;
import com.halcyon.service.UserManageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("usermanage")
public class UserManage {

        @Autowired
        private UserManageService userManageService;

//        @ResponseBody
//        @RequestMapping(value = "/queryUserPage",method = RequestMethod.POST)
//        public List<TUser> queryUserPage(Integer page) {
//            int pageNow = page == null ? 1 : page;
//            int pageSize = 10;
//            int startRows = Math.abs(pageSize*(pageNow-1));
//            return userManageService.queryUserPage(startRows);
//        }

        @ResponseBody
        @RequestMapping(value = "/selectUserPage",method = RequestMethod.POST)
        public List<TUser> selectUserPage(String userId, String userNickname, Integer page) {
            int pageNow = page == null ? 1 : page;
            int pageSize = 10;
            int startRows = Math.abs(pageSize*(pageNow-1));
            return userManageService.selectUserPage(userId, userNickname, startRows);
        }
    @ResponseBody
    @RequestMapping(value = "/selectUserPage1",method = RequestMethod.POST)
    public List<TUser> selectUserPage1(String userId, String userNickname) {
        return userManageService.selectUserPage1(userId, userNickname);
    }

        @ResponseBody
        @RequestMapping(value = "/getRowCount",method = RequestMethod.POST)
        public Integer getRowCount(String userId, String userNickname) {
            return userManageService.getRowCount(userId, userNickname);
        }

        @ResponseBody
        @RequestMapping(value = "/createUser",method = RequestMethod.POST)
        public Integer createUser(TUser user) {
            return userManageService.createUser(user);
        }

        @ResponseBody
        @RequestMapping(value = "/deleteUserById",method = RequestMethod.POST)
        public Integer deleteUserById(String tuId) {
            return userManageService.deleteUserById(tuId);
        }

        @ResponseBody
        @RequestMapping(value = "/deleteUserByIdList",method = RequestMethod.POST)
        public Integer deleteUserByIdList(String tuIdList) {
            String tuIdListSub = tuIdList.substring(0, tuIdList.length()-1);
            List tuIds = new ArrayList();
            for (String userIdStr: tuIdListSub.split(",")){
                tuIds.add(userIdStr.trim());
            }
            System.out.println(tuIds);
            return userManageService.deleteUserByIdList(tuIds);
        }

        @ResponseBody
        @RequestMapping(value = "/updateUserById",method = RequestMethod.POST)
        public Integer updateUserById(TUser user) {
            return userManageService.updateUserById(user);
        }
    }


