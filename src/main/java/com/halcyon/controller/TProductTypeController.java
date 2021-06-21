package com.halcyon.controller;

import com.halcyon.entity.TProductType;
import com.halcyon.service.impl.TProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("type")
public class TProductTypeController {
    @Autowired
    private TProductTypeServiceImpl productTypeService;

    @RequestMapping(value = "/getAllTid",method = RequestMethod.POST)
    public List<String> gettid() {
        return productTypeService.getAllTid();
    }
}
