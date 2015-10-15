package com.one.shop.repository;

import com.one.shop.entity.GoodsEntity;
import com.one.shop.entity.HottestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pein on 2015/10/13.
 */
@Repository
@Transactional
public interface HottestRepository extends PagingAndSortingRepository<HottestEntity,Long> {
}
