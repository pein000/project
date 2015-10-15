package com.one.shop.repository;

import com.one.shop.entity.RevealedEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pein on 2015/10/13.
 */
@Repository
@Transactional
public interface RevealedRepository extends PagingAndSortingRepository<RevealedEntity, Long> {
}
