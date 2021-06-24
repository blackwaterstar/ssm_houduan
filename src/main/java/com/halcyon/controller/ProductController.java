package com.halcyon.controller;

import com.halcyon.entity.TProduct;
import com.halcyon.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @ResponseBody
    @RequestMapping("/list")
    public List<TProduct> getProducts(){
        return productService.getProducts();
    }

    @ResponseBody
    @RequestMapping(value = "/getProductById",method = RequestMethod.POST)
    public TProduct getProductById(Long pid){

        return productService.getProductById(pid);
    }



    @ResponseBody
    @RequestMapping(value = "/queryUserPage",method = RequestMethod.POST)
    public List<TProduct> queryUserPage(Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = pageSize*(pageNow-1);
        return productService.queryTwPage(startRows);
    }

    @ResponseBody
    @RequestMapping(value = "/selectTwPage",method = RequestMethod.POST)
    public List<TProduct> selectTwPage(String pname, String tid, Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = pageSize*(pageNow-1);
        return productService.selectTwPage(pname, tid, startRows);
    }

    @ResponseBody
    @RequestMapping(value = "/getRowCount",method = RequestMethod.POST)
    public Integer getRowCount(String pname, String tid) {
        return productService.getRowCount(pname, tid);
    }

    @ResponseBody
    @RequestMapping(value = "/createTw",method = RequestMethod.POST)
    public Integer createUser(TProduct tProduct) {
        return productService.createTw(tProduct);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteTwById",method = RequestMethod.POST)
    public Integer deleteUserById(String twId) {
        return productService.deleteTwById(twId);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteTwByIdList",method = RequestMethod.POST)
    public Integer deleteUserByIdList(String tpIdList) {
        String tuIdListSub = tpIdList.substring(0, tpIdList.length()-1);
        List tuIds = new ArrayList();
        for (String userIdStr: tuIdListSub.split(",")){
            tuIds.add(userIdStr.trim());
        }
        return productService.deleteTwByIdList(tuIds);
    }

    @ResponseBody
    @RequestMapping(value = "/updateTwById",method = RequestMethod.POST)
    public Integer updateUserById(TProduct tProduct) {
        return productService.updateTwById(tProduct);
    }



}
