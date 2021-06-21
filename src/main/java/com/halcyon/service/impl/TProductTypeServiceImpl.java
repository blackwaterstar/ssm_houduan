package com.halcyon.service.impl;

import com.halcyon.entity.TProductType;
import com.halcyon.mapper.TProductTypeMapper;
import com.halcyon.service.TProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TProductTypeServiceImpl implements TProductTypeService {

    @Autowired
    private TProductTypeMapper tProductTypeMapper;

    @Override
    public List<String> getAllTid() {
        return tProductTypeMapper.getAllTid();
    }
}
