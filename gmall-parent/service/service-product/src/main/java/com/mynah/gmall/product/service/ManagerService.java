package com.mynah.gmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mynah.gmall.model.product.*;

import java.util.List;

public interface ManagerService {
    List<BaseCategory1> getCategory1();

    List<BaseCategory2> getCategory2(Long categoryId);

    List<BaseCategory3> getCategory3(Long category2Id);

    List<BaseAttrInfo> attrInfoList(Long category1Id, Long category2Id, Long category3Id);

    //增加平台属性
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    //删除平台属性
    void deleteAttrInfo(BaseAttrInfo baseAttrInfo);

    //获取品牌分页列表
    IPage baseTrademark(Integer page, Integer limit);


    List<BaseTrademark> getTrademarkList();

    List<BaseSaleAttr> baseSaleAttrList();

    void saveSpuInfo(SpuInfo spuInfo);

    IPage<SpuInfo> SpuInfoPage(Integer page, Integer limit, Long category3Id);


    List<SpuImage> spuImageList(Long spuId);

    List<SpuSaleAttr> spuSaleAttrList(Long spuId);

    void saveSkuInfo(SkuInfo skuInfo);

    IPage<SkuInfo> list(Integer page, Integer limit);

    void onSale(Long skuId);

    void cancelSale(Long skuId);
}
