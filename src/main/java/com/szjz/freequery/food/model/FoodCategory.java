package com.szjz.freequery.food.model;

import com.szjz.freequery.base.BaseEntity;
import com.szjz.freequery.food.enums.FoodCategoryStatusEnum;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @date 2019-10-18
 */
@Data
@SQLDelete(sql = "update food_category set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
@Entity
@Table(name = "food_category")
public class FoodCategory extends BaseEntity implements Serializable {
    /** 分类名称 */
    @Column(nullable = false)
    private String name;

    /** 排列 序号 */
    @Column(nullable = false)
    private Integer sort;

    /** 操作者ID */
    @Column(nullable = false)
    private Long createBy;

    /** 状态 */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FoodCategoryStatusEnum status;

    /** 备注 */
    private String remark;

    private static final long serialVersionUID = 1L;

}
