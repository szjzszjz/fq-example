/*
 * Copyright (c) 2018, BENMA and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.szjz.freequery.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 创建时间 */
    @Column(nullable = false, updatable = false)
    private Date gmtCreate;

    /** 修改时间 */
    @ApiModelProperty(hidden = true)
    @Column(nullable = false)
    private Date gmtModified;

    /** 是否已删除 */
    @Column(nullable = false)
    @JsonIgnore
    private Boolean isDeleted;

}
