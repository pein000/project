package com.one.shop.repository;

import com.one.shop.entity.PointFlowEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pein on 2015/10/13.
 */
@Repository
@Transactional
public interface PointFlowRepository extends CrudRepository<PointFlowEntity,Integer> {
}
