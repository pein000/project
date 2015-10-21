package com.one.shop.repository;

import com.one.shop.entity.CashAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pein on 2015/10/13.
 */
@Repository
@Transactional
public interface CashAccountRepository extends CrudRepository<CashAccountEntity,Integer> {
    public CashAccountEntity findByUserId(int userId);
}
