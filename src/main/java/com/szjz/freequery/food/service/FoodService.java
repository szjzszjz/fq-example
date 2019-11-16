package com.szjz.freequery.food.service;

import com.szjz.freequery.base.BaseService;
import com.szjz.freequery.food.model.Food;

public interface FoodService extends BaseService<Food> {
    /** 创建 */
    Food create(Food food);
}
