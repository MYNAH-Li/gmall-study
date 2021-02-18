package com.mynah.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mynah.gmall.common.result.Result;
import com.mynah.gmall.model.product.*;
import com.mynah.gmall.product.mapper.*;
import com.mynah.gmall.product.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;
    @Autowired
    private BaseTrademarkMapper baseTrademarkMapper;

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

    //添加属性
    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        //插入属性列表
        baseAttrInfoMapper.insert(baseAttrInfo);

        //插入属性值
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        attrValueList.forEach((baseAttrValue)->{
            baseAttrValue.setAttrId(baseAttrInfo.getId());
            baseAttrValueMapper.insert(baseAttrValue);
        });

    }

    //删除平台属性
    @Override
    public void deleteAttrInfo(BaseAttrInfo baseAttrInfo) {
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        attrValueList.forEach((baseAttrValue)->{
            baseAttrValue.setAttrId(baseAttrInfo.getId());
            baseAttrValueMapper.delete(new QueryWrapper<BaseAttrValue>(baseAttrValue));
        });
    }

    @Override
    public IPage baseTrademark(Integer page, Integer limit) {
        return baseTrademarkMapper.selectPage(new Page<BaseTrademark>(page, limit), null);
    }

    @Override
    public List<BaseTrademark> getTrademarkList() {
        return baseTrademarkMapper.selectList(null);
    }


}
