package com.szjz.freequery.food.model;
import com.szjz.freequery.base.BaseEntity;
import com.szjz.freequery.food.enums.FoodSizeEnum;
import com.szjz.freequery.food.enums.FoodStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @date 2019-10-12
 */
@Data
@SQLDelete(sql = "update food set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
@Entity
@Table(name = "food")
public class  Food extends BaseEntity implements Serializable {
    /** 食品名称 */
    @Column(nullable = false)
    private String name;

    /** 排序/序号 */
    @ApiModelProperty(hidden = true)
    private Integer sort;

    /** 编号 */
    private Integer no;

    /** 分类ID */
    private Long categoryId;

    /** 单价/现价/抢购价 */
    @Column(nullable = false)
    private BigDecimal currentPrice;

    /** 原价 */
    private BigDecimal originalPrice;

    /** 是否有规格 */
    private Boolean isSize;

    /** 食品规格 */
    private FoodSizeEnum size;

    /** 库存/数量 */
    @Column(nullable = false)
    private Integer stock;

    /** 点赞数量 */
    @Column(nullable = false)
    private Integer praiseCount;

    /** 描述 */
    private String description;

    /** 食品图片链接 */
    private String icon;

    /** 禁用、启用 ————》上架下架*/
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FoodStatusEnum status;

    /** 操作者ID */
    @Column(nullable = false)
    private Long createBy;

    /** 备注 */
    private String remark;

    private static final long serialVersionUID = 1L;


}
