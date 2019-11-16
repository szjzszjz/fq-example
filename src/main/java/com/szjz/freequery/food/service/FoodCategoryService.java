package com.szjz.freequery.food.service;
import com.szjz.freequery.base.BaseService;
import com.szjz.freequery.food.model.FoodCategory;

public interface FoodCategoryService extends BaseService<FoodCategory> {
    /** 创建 */
    FoodCategory create(FoodCategory foodCategory);

}
