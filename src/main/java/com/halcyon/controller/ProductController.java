package com.halcyon.controller;

import com.halcyon.entity.TProduct;
import com.halcyon.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    @RequestMapping(value = "/list1",method = RequestMethod.POST)
    public List<TProduct> getProducts1(String tid,String pname){
        return productService.getProducts(tid,pname);
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
        int startRows = Math.abs(pageSize*(pageNow-1));
        return productService.queryTwPage(startRows);
    }

    @ResponseBody
    @RequestMapping(value = "/selectTwPage",method = RequestMethod.POST)
    public List<TProduct> selectTwPage(String pname, String tid, Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = Math.abs(pageSize*(pageNow-1));
        return productService.selectTwPage(pname, tid, startRows);
    }
    @ResponseBody
    @RequestMapping(value = "/selectTwPage1",method = RequestMethod.POST)
    public List<TProduct> selectTwPage1(String pname, String tid) {
        return productService.selectTwPage1(pname, tid);
    }

    @ResponseBody
    @RequestMapping(value = "/getRowCount",method = RequestMethod.POST)
    public Integer getRowCount(String pname, String tid) {
        return productService.getRowCount(pname, tid);
    }

    @ResponseBody
    @RequestMapping(value = "/createTw",method = RequestMethod.POST)
    public Integer createUser(TProduct tProduct) {
        String path = tProduct.getPimg();
        String temp[] = path.split("\\\\");

          String  name = temp[temp.length - 1];
          String newpath = "http://localhost:8080/ssm/img/"+name;
          tProduct.setPimg(newpath);

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
        String path = tProduct.getPimg();
        String temp[] = path.split("\\\\");

        String  name = temp[temp.length - 1];
        String newpath = "http://localhost:8080/ssm/img/"+name;
        tProduct.setPimg(newpath);
        return productService.updateTwById(tProduct);
    }


}
