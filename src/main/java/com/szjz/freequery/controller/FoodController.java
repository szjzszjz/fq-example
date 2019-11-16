package com.szjz.freequery.controller;

import com.szjz.freequery.FQList;
import com.szjz.freequery.FQObj;
import com.szjz.freequery.controller.abs.AbstractController;
import com.szjz.freequery.food.enums.FoodSizeEnum;
import com.szjz.freequery.food.enums.FoodStatusEnum;
import com.szjz.freequery.food.model.Food;
import com.szjz.freequery.food.service.FoodService;
import com.szjz.freequery.responsemodel.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("/v1/foods")
public class FoodController extends AbstractController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private FQList fqList;
    @Autowired
    private FQObj fqObj;

    @RequestMapping(value = "/fq/list", method = RequestMethod.GET)
    @ApiOperation(value = "自由列列表查询", notes = "根据需求动态查询所需要的列, 在需要查询的字段后面输入1即可,不输入则查询全部字段，如果希望结果分页返回，请输入对应的数据", response = Result.class)
    public Result freeQuery(Food food,
                            @RequestParam(required = false) Integer pageNum,
                            @RequestParam(required = false) Integer pageSize) {
        Object data = fqList
                .addObject(food)
                .addCondition("is_deleted = false")
                .addPageNum(pageNum)
                .addPageSize(pageSize)
                .query();
        return Result.success(data);
    }


    @RequestMapping(value = "/fq/object", method = RequestMethod.GET)
    @ApiOperation(value = "自由列对象查询", notes = "根据需求动态查询所需要的单独对象的列。输入对象ID， 然后在需要查询的字段后面输入1即可," +
            "不输入则查询对象全部字段", response = Result.class)
    public Result queryColObject(Food food) {
        Object data = fqObj
                .addObject(food)
                .addCondition("id = " + food.getId())
                .addCondition("is_deleted = false")
                .query();
        return success(data);
    }
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "", response = Result.class)
    public Result create(
            @RequestParam String name,
            @RequestParam Integer sort,
            @RequestParam Integer no,
            @RequestParam Long categoryId,
            @RequestParam BigDecimal currentPrice,
            @RequestParam Integer stock,
            @RequestParam String icon,
            @RequestParam Boolean isSize,
            @RequestParam(required = false) BigDecimal originalPrice,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String remark) {
        // 填充参数
        Food food = new Food();
        food.setName(name);
        food.setCategoryId(categoryId);
        food.setCurrentPrice(currentPrice);
        food.setOriginalPrice(originalPrice);
        food.setStock(stock);
        food.setIsSize(isSize);
        food.setNo(no);
        food.setDescription(description);
        food.setIcon(icon);
        food.setCreateBy(100l);
        food.setSize(FoodSizeEnum.big);
        food.setStatus(FoodStatusEnum.sell_on);
        food.setPraiseCount(0);
        food.setSort(sort);
        food.setRemark(remark);

        food = this.foodService.create(food);
        return super.success(food);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "详情", notes = "", response = Result.class)
    public Result get(@PathVariable("id") Long id) {
        Food food = this.foodService.getById(id);
        if (food == null) {
            return super.gone();
        }
        return super.success(food);
    }


}
