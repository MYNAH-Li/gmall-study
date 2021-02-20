package com.mynah.gmall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mynah.gmall.model.product.*;
import com.mynah.gmall.product.service.ManagerService;
import com.mynah.gmall.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("getCategory1")
    public Result getCategory1(){
        List<BaseCategory1> list = managerService.getCategory1();
        return Result.ok(list);
    }

    @GetMapping("/getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable(name = "category1Id") Long category1Id){
        List<BaseCategory2> list = managerService.getCategory2(category1Id);
        return Result.ok(list);
    }

    @GetMapping("/getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable(name="category2_id")Long category2Id){
        List<BaseCategory3> list = managerService.getCategory3(category2Id);
        return Result.ok(list);
    }

    @GetMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result attrInfoList(
            @PathVariable(name = "category1Id")Long category1Id,
            @PathVariable(name = "category2Id")Long category2Id,
            @PathVariable(name = "category3Id")Long category3Id
    ){
        List<BaseAttrInfo> list = managerService.attrInfoList(
                category1Id,
                category2Id,
                category3Id
        );
        return Result.ok(list);
    }

    //增加平台属性
    @PostMapping("saveAttrInfo")
    public Result saveAttrInfo(BaseAttrInfo baseAttrInfo){
        managerService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }

    //删除平台属性
    @PostMapping("deleteAttrInfo")
    public Result deleteAttrInfo(BaseAttrInfo baseAttrInfo){
        managerService.deleteAttrInfo(baseAttrInfo);
        return Result.ok();
    }


    //获取品牌分页列表
    @GetMapping("baseTrademark/{page}/{limit}")
    public Result baseTrademark(@PathVariable(name = "page") Integer page,
                                @PathVariable(name = "limit") Integer limit)
    {
        IPage iPage = managerService.baseTrademark(page, limit);
        return Result.ok(iPage);
    }

    //获取品牌
    @GetMapping("baseTrademark/getTrademarkList")
    public Result getTrademarkList(){
        List<BaseTrademark> list = managerService.getTrademarkList();
        return Result.ok(list);
    }

    //获取销售属性表
    public Result baseSaleAttrList(){
        List<BaseSaleAttr> list = managerService.baseSaleAttrList();
        return Result.ok(list);
    }

    //spu保存
    @GetMapping("/saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo){

        managerService.saveSpuInfo(spuInfo);

        return Result.ok();
    }

    //查询SKU分页列表
    @GetMapping("/{page}/{limit}?category3Id=61")
    public Result SpuInfoPage(@PathVariable(name = "page") Integer page,
                              @PathVariable(name = "limit") Integer limit,
                              Long category3Id){
        IPage<SpuInfo> iPage = managerService.SpuInfoPage(page,limit,category3Id);
        return Result.ok(iPage);
    }

    //根据spuid查询商品图片
    @GetMapping("/spuImageList/{spuId}")
    public Result spuImageList(@PathVariable(name = "spuId") Long spuId){
        List<SpuImage> list = managerService.spuImageList(spuId);
        return Result.ok();
    }

    //根据spuid查询销售属性及销售属性值
    @GetMapping("/spuSaleAttrList/{spuId}")
    public Result spuSaleAttrList(@PathVariable(name= "spuId") Long spuId){
        List<SpuSaleAttr> list = managerService.spuSaleAttrList(spuId);
        return Result.ok();
    }

    //添加sku
    @PostMapping("/saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfo skuInfo){
        managerService.saveSkuInfo(skuInfo);
        return Result.ok();
    }

    //获取sku分页列表
    @GetMapping("/list/{page}/{limit}")
    public Result list(@PathVariable(name = "page") Integer page,
                       @PathVariable(name = "limit") Integer limit){
        IPage<SkuInfo> iPage = managerService.list(page,limit);
        return Result.ok(iPage);
    }

    //上架
    @GetMapping("/onSale/{skuId}")
    public Result onSale(@PathVariable(name = "skuId") Long skuId){
        managerService.onSale(skuId);
        return Result.ok();
    }

    //下架
    @GetMapping("/cancelSale/{skuId}")
    public Result cancelSale(@PathVariable(name = "skuId") Long skuId){
        managerService.cancelSale(skuId);
        return Result.ok();
    }
}

