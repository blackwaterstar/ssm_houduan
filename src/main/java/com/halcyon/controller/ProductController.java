package com.halcyon.controller;

import com.halcyon.entity.TProduct;
import com.halcyon.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @ResponseBody
    @RequestMapping("list")
    public List<TProduct> getProducts(){
        return productService.getProducts();
    }

    @RequestMapping("getProductById")
    public TProduct getProductById(Long pid){

        return productService.getProductById(pid);
    }



}
