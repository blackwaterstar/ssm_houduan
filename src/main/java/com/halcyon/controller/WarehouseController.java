package com.halcyon.controller;

import com.halcyon.entity.TWarehouse;
import com.halcyon.service.IwarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
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
    public List<TWarehouse> selectTwPage(String pname, String tid, Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = pageSize*(pageNow-1);
        return iwarehouseService.selectTwPage(pname, tid, startRows);
    }

    @ResponseBody
    @RequestMapping(value = "/getRowCount",method = RequestMethod.POST)
    public Integer getRowCount(String pname, String tid) {
        return iwarehouseService.getRowCount(pname, tid);
    }

    @ResponseBody
    @RequestMapping(value = "/createTw",method = RequestMethod.POST)
    public Integer createUser(TWarehouse tWarehouse) {
        return iwarehouseService.createTw(tWarehouse);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteTwById",method = RequestMethod.POST)
    public Integer deleteUserById(String twId) {
        return iwarehouseService.deleteTwById(twId);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteTwByIdList",method = RequestMethod.POST)
    public Integer deleteUserByIdList(String twIdList) {
        System.out.println(twIdList);
        String tuIdListSub = twIdList.substring(0, twIdList.length()-1);
//        String[] userIds = twIdList.split(",");

        List tuIds = new ArrayList();
        for (String userIdStr: tuIdListSub.split(",")){
            tuIds.add(userIdStr.trim());
        }
        return iwarehouseService.deleteTwByIdList(tuIds);
    }

    @ResponseBody
    @RequestMapping(value = "/updateTwById",method = RequestMethod.POST)
    public Integer updateUserById(TWarehouse tWarehouse) {
        return iwarehouseService.updateTwById(tWarehouse);
    }
}
