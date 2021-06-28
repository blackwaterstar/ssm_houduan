package com.halcyon.controller;

import com.halcyon.entity.TProductType;
import com.halcyon.service.TProductTypeService;
import com.halcyon.service.impl.TProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("type")
public class TProductTypeController {
    @Autowired
  private TProductTypeService tProductTypeService;

    @ResponseBody
    @RequestMapping(value = "/getAllTid",method = RequestMethod.POST)
    public List<TProductType> gettid() {
        return tProductTypeService.getAllTid();
    }

    @ResponseBody
    @RequestMapping(value = "/queryUserPage",method = RequestMethod.POST)
    public List<TProductType> queryUserPage(Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = pageSize*(pageNow-1);
        return tProductTypeService.queryTwPage(startRows);
    }

    @ResponseBody
    @RequestMapping(value = "/selectTwPage",method = RequestMethod.POST)
    public List<TProductType> selectTwPage(String tname, String tid, Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = pageSize*(pageNow-1);
        return tProductTypeService.selectTwPage(tname, tid, startRows);
    }
    @ResponseBody
    @RequestMapping(value = "/selectTwPage1",method = RequestMethod.POST)
    public List<TProductType> selectTwPage1(String tname, String tid) {
        return tProductTypeService.selectTwPage1(tname, tid);
    }

    @ResponseBody
    @RequestMapping(value = "/getRowCount",method = RequestMethod.POST)
    public Integer getRowCount(String tname, String tid) {
        return tProductTypeService.getRowCount(tname, tid);
    }

    @ResponseBody
    @RequestMapping(value = "/createTw",method = RequestMethod.POST)
    public Integer createUser(TProductType tProductType) {
        return tProductTypeService.createTw(tProductType);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteTwById",method = RequestMethod.POST)
    public Integer deleteUserById(String ttId) {
        return tProductTypeService.deleteTwById(ttId);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteTwByIdList",method = RequestMethod.POST)
    public Integer deleteUserByIdList(String ttIdList) {
        String tuIdListSub = ttIdList.substring(0, ttIdList.length()-1);
        List ttIds = new ArrayList();
        for (String userIdStr: tuIdListSub.split(",")){
            ttIds.add(userIdStr.trim());
        }
        return tProductTypeService.deleteTwByIdList(ttIds);
    }

    @ResponseBody
    @RequestMapping(value = "/updateTwById",method = RequestMethod.POST)
    public Integer updateUserById(TProductType tProductType) {
        return tProductTypeService.updateTwById(tProductType);
    }

}
