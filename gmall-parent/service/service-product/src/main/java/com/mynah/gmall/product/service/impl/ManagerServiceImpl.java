package com.mynah.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mynah.gmall.model.product.BaseAttrInfo;
import com.mynah.gmall.model.product.BaseCategory2;
import com.mynah.gmall.model.product.BaseCategory3;
import com.mynah.gmall.product.mapper.BaseAttrInfoMapper;
import com.mynah.gmall.product.mapper.BaseCategory1Mapper;
import com.mynah.gmall.product.mapper.BaseCategory2Mapper;
import com.mynah.gmall.product.mapper.BaseCategory3Mapper;
import com.mynah.gmall.product.service.ManagerService;
import com.mynah.gmall.model.product.BaseCategory1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private BaseCategory1Mapper baseCategory1Mapper;
    @Autowired
    private BaseCategory2Mapper baseCategory2Mapper;
    @Autowired
    private BaseCategory3Mapper baseCategory3Mapper;
    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Override
    public List<BaseCategory1> getCategory1() {
        baseCategory1Mapper.selectList(null);
        return null;
    }

    @Override
    public List<BaseCategory2> getCategory2(Long category1Id) {

        return baseCategory2Mapper.selectList(new QueryWrapper<BaseCategory2>().eq("category1_id",category1Id));
    }

    @Override
    public List<BaseCategory3> getCategory3(Long category2Id) {
        return baseCategory3Mapper.selectList(new QueryWrapper<BaseCategory3>().eq("category2_id",category2Id));
    }

    @Override
    public List<BaseAttrInfo> attrInfoList(Long category1Id, Long category2Id, Long category3Id) {
        return baseAttrInfoMapper.attrInfoList(category1Id,category2Id,category3Id);
    }
}
