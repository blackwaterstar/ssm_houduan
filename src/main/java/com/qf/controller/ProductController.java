package com.qf.controller;

import com.qf.entity.TProduct;
import com.qf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @RequestMapping("list")
    public List<TProduct> getProducts(){
        return productService.getProducts();
    }

    @RequestMapping("getProductById")
    public TProduct getProductById(Long pid){

        return productService.getProductById(pid);
    }



}
