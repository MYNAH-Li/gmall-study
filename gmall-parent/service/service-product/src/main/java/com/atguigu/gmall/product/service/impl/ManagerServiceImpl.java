package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.product.mapper.BaseCategory1Mapper;
import com.atguigu.gmall.product.service.ManagerService;
import com.mynah.gmall.model.product.BaseCategory1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private BaseCategory1Mapper baseCategory1Mapper;

    @Override
    public List<BaseCategory1> getCategory1() {
        baseCategory1Mapper.selectList(null);
        return null;
    }
}
