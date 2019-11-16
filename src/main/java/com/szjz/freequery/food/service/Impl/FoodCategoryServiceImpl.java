package com.szjz.freequery.food.service.Impl;

import com.szjz.freequery.base.BaseServiceImpl;
import com.szjz.freequery.food.model.FoodCategory;
import com.szjz.freequery.food.repository.FoodCategoryRepository;
import com.szjz.freequery.food.service.FoodCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

@Service
@Transactional
public class FoodCategoryServiceImpl extends BaseServiceImpl<FoodCategory> implements FoodCategoryService {

    public FoodCategoryServiceImpl(FoodCategoryRepository baseRepository) {
        super(baseRepository);
    }

    /** 创建 */
    @Override
    public FoodCategory create(FoodCategory foodCategory) {
        foodCategory.setGmtCreate(new Date());
        foodCategory.setGmtModified(new Date());
        foodCategory.setIsDeleted(false);
        return super.baseRepository.save(foodCategory);
    }


}
