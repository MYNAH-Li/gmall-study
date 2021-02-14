package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.product.service.ManagerService;
import com.mynah.gmall.common.result.Result;
import com.mynah.gmall.model.product.BaseCategory1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
