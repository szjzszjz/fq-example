package com.szjz.freequery.controller;

import com.szjz.freequery.FQList;
import com.szjz.freequery.FQObj;
import com.szjz.freequery.controller.abs.AbstractController;
import com.szjz.freequery.food.enums.FoodSizeEnum;
import com.szjz.freequery.food.enums.FoodStatusEnum;
import com.szjz.freequery.food.model.Food;
import com.szjz.freequery.food.model.Test;
import com.szjz.freequery.food.service.FoodService;
import com.szjz.freequery.responsemodel.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/test")
public class TestController extends AbstractController {

    @Autowired
    private FQList fqList;

    @RequestMapping(value = "/fq/list", method = RequestMethod.GET)
    @ApiOperation(value = "自由列列表查询", notes = "根据需求动态查询所需要的列, 在需要查询的字段后面输入1即可,不输入则查询全部字段，如果希望结果分页返回，请输入对应的数据", response = Result.class)
    public Result freeQuery(Test test) {
        Object data = fqList
                .addObject(test)
                .addCondition("is_deleted = false")
                .query();
        return Result.success(data);
    }




}
