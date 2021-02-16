package com.mynah.gmall.product.controller;

import com.mynah.gmall.model.product.BaseAttrInfo;
import com.mynah.gmall.model.product.BaseCategory2;
import com.mynah.gmall.model.product.BaseCategory3;
import com.mynah.gmall.product.service.ManagerService;
import com.mynah.gmall.common.result.Result;
import com.mynah.gmall.model.product.BaseCategory1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
