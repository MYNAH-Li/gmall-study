package com.mynah.gmall.product.service;

import com.mynah.gmall.model.product.BaseAttrInfo;
import com.mynah.gmall.model.product.BaseCategory1;
import com.mynah.gmall.model.product.BaseCategory2;
import com.mynah.gmall.model.product.BaseCategory3;

import java.util.List;

public interface ManagerService {
    List<BaseCategory1> getCategory1();

    List<BaseCategory2> getCategory2(Long categoryId);

    List<BaseCategory3> getCategory3(Long category2Id);

    List<BaseAttrInfo> attrInfoList(Long category1Id, Long category2Id, Long category3Id);
}
