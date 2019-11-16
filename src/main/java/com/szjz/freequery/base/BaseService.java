package com.szjz.freequery.base;


import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    void deleteById(Long id);


    /**
     * 根据id查询
     *
     * @param id
     * @return isDeleted==true的记录
     */
    T getById(Long id);
    T getById(Long id, String name);

    /**
     * 根据id集合查询
     *
     * @param idList
     * @return isDeleted==true的记录
     */
    List<T> findAllByIds(List<Long> idList);

    /**
     * 获取所有的有效数据库
     *
     * @return isDeleted==true的记录
     */
    List<T> findAll();

    /**
     * 分页查询有效的数据
     *
     * @param pageNumber
     * @param pageSize
     * @return page
     */
    Page<T> findAllByPage(Integer pageNumber, Integer pageSize);

    /**
     * 计算总量
     */
    Long count(Integer integer);


}
