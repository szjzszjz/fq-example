package com.szjz.freequery.controller;
import com.szjz.freequery.FQList;
import com.szjz.freequery.FQObj;
import com.szjz.freequery.controller.abs.AbstractController;
import com.szjz.freequery.food.model.FoodCategory;
import com.szjz.freequery.responsemodel.Result;
import com.szjz.freequery.food.service.FoodCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/foodCategories")
public class FoodCategoryController extends AbstractController {
    @Autowired
    private FoodCategoryService foodCategoryService;

    @Autowired
    private FQList fqList;
    @Autowired
    private FQObj fqObj;

    @RequestMapping(value = "/fq/list", method = RequestMethod.GET)
    @ApiOperation(value = "自由列列表查询", notes = "根据需求动态查询所需要的列, 在需要查询的字段后面输入1即可,不输入则查询全部字段，如果希望结果分页返回，请输入对应的数据", response = Result.class)
    public Result freeQuery(FoodCategory foodCategory,
                            @RequestParam(required = false) Integer pageNum,
                            @RequestParam(required = false) Integer pageSize) {
        Object data = fqList
                .addObject(foodCategory)
                .addCondition("is_deleted = false")
                .addPageNum(pageNum)
                .addPageSize(pageSize)
                .query();
        return Result.success(data);
    }


    @RequestMapping(value = "/fq/object", method = RequestMethod.GET)
    @ApiOperation(value = "自由列对象查询", notes = "根据需求动态查询所需要的单独对象的列。输入对象ID， 然后在需要查询的字段后面输入1即可," +
            "不输入则查询对象全部字段", response = Result.class)
    public Result queryColObject(FoodCategory foodCategory) {
        Object data = fqObj
                .addObject(foodCategory)
                .addCondition("id = " + foodCategory.getId())
                .addCondition("is_deleted = false")
                .query();
        return success(data);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "详情", notes = "", response = Result.class)
    public Result get(@PathVariable("id") Long id) {
        FoodCategory foodCategory = this.foodCategoryService.getById(id);
        if (foodCategory == null) {
            return super.gone();
        }
        return super.success(foodCategory);
    }



}
