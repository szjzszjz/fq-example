package com.szjz.freequery.food.service.Impl;

import com.szjz.freequery.base.BaseServiceImpl;
import com.szjz.freequery.food.model.Food;
import com.szjz.freequery.food.repository.FoodRepository;
import com.szjz.freequery.food.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Slf4j
@Service
@Transactional
public class FoodServiceImpl extends BaseServiceImpl<Food> implements FoodService {

    public FoodServiceImpl(FoodRepository baseRepository) {
        super(baseRepository);
    }

    /**
     * 创建
     */
    @Override
    public Food create(Food food) {
        food.setGmtCreate(new Date());
        food.setGmtModified(new Date());
        food.setIsDeleted(false);
        return super.baseRepository.save(food);
    }

}
