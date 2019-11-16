package com.szjz.freequery.base;

import com.szjz.freequery.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Slf4j
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    protected BaseRepository<T> baseRepository;

    public BaseServiceImpl(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Autowired
    protected EntityManager entityManager;

    /**
     * 直接保存, 不做任何设置(包括更新时间)
     */
    protected final T updateDirect(T t) {
        if (t == null) {
            throw new BusinessException("参数t不能为空");
        }
        if (t.getId() == null) {
            throw new BusinessException("id不能为空");
        }

        return this.baseRepository.saveAndFlush(t);
    }

    /**
     * 更新所有字段
     */
    protected final T updateAll(T t) {
        if (t == null) {
            throw new BusinessException("参数t不能为空");
        }
        if (t.getId() == null) {
            throw new BusinessException("id不能为空");
        }

        t.setGmtModified(new Date());
        return this.baseRepository.saveAndFlush(t);
    }


    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new BusinessException("id不能为空");
        }

        // 注意, 这里不要调用 this.getById(id), 该方法是允许被重写的
        T t = this.baseRepository.findById(id).orElse(null);
        if (t != null) {
            t.setIsDeleted(true);
            t.setGmtModified(new Date());
            this.updateAll(t);
        }
    }

    @Override
    public T getById(Long id) {
        if (id == null) {
            return null;
        }
        return this.baseRepository.findById(id).orElse(null);
    }

    @Override
    public T getById(Long id, String name) {
        if (id == null) {
            return null;
        }
        T t = this.baseRepository.findById(id).orElse(null);
        if (t == null) {
            throw new BusinessException(name + "不存在!");
        }
        return t;
    }

    /**
     * 根据id集合获取对应的实体集合
     */
    @Override
    public List<T> findAllByIds(List<Long> idList) {
        return this.baseRepository.findAllById(idList);
    }


    /**
     * 获取所有 不分页
     */
    @Override
    public List<T> findAll() {
        return this.baseRepository.findAll();
    }

    /**
     * 按照ID降序 分页查询有效的数据
     */
    @Override
    public Page<T> findAllByPage(Integer pageNumber, Integer pageSize) {
        PageRequest request = PageRequest.of(pageNumber, pageSize, Sort.by(new Sort.Order(Sort.Direction.DESC, "id")));
        Page<T> tPage = baseRepository.findAll(request);
        List<T> content = tPage.getContent();
        //对数据进行过滤处理
        PageImpl<T> page = new PageImpl<>(content, request, tPage.getTotalElements());
        return page;
    }


    /**
     * 计算总量
     */
    @Override
    public Long count(Integer integer) {
        return baseRepository.count();
    }

}
