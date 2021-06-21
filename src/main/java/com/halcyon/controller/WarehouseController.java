package com.halcyon.controller;

import com.halcyon.entity.TWarehouse;
import com.halcyon.service.IwarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("warehouse")
public class WarehouseController {
    @Autowired
    private IwarehouseService iwarehouseService;

    @ResponseBody
    @RequestMapping(value = "/queryUserPage",method = RequestMethod.POST)
    public List<TWarehouse> queryUserPage(Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = pageSize*(pageNow-1);
        return iwarehouseService.queryTwPage(startRows);
    }

    @ResponseBody
    @RequestMapping(value = "/selectTwPage",method = RequestMethod.POST)
    public List<TWarehouse> selectTwPage(String tid, String pid, Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = pageSize*(pageNow-1);
        return iwarehouseService.selectTwPage(tid, pid, startRows);
    }

    @ResponseBody
    @RequestMapping(value = "/getRowCount",method = RequestMethod.POST)
    public Integer getRowCount(String tid, String pid) {
        return iwarehouseService.getRowCount(tid, pid);
    }

    @ResponseBody
    @RequestMapping(value = "/createTw",method = RequestMethod.POST)
    public Integer createUser(TWarehouse user) {
//            Random random = new Random();
//            Integer number = random.nextInt(9000) + 1000;
//            user.setUserId(System.currentTimeMillis() + String.valueOf(number));
        return iwarehouseService.createTw(user);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUserById",method = RequestMethod.POST)
    public Integer deleteUserById(String tuId) {
        return iwarehouseService.deleteTwById(tuId);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUserByIdList",method = RequestMethod.POST)
    public Integer deleteUserByIdList(String tuIdList) {
        String tuIdListSub = tuIdList.substring(0, tuIdList.length()-1);
//        String[] userIds = tuIdList.split(",");

        List tuIds = new ArrayList();
        for (String userIdStr: tuIdListSub.split(",")){
            tuIds.add(userIdStr.trim());
        }
        return iwarehouseService.deleteTwByIdList(tuIds);
    }

    @ResponseBody
    @RequestMapping(value = "/updateUserById",method = RequestMethod.POST)
    public Integer updateUserById(TWarehouse user) {
        return iwarehouseService.updateTwById(user);
    }
}
