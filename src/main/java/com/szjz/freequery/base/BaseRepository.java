package com.szjz.freequery.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//, QuerydslPredicateExecutor<T>
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> , JpaSpecificationExecutor<T>  {
}
