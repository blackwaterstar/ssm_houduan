package com.halcyon.controller;

import com.halcyon.entity.TProductType;
import com.halcyon.service.impl.TProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("type")
public class TProductTypeController {
    @Autowired
    private TProductTypeServiceImpl productTypeService;

    @ResponseBody
    @RequestMapping(value = "/getAllTid",method = RequestMethod.POST)
    public List<TProductType> gettid() {
        return productTypeService.getAllTid();
    }
}
