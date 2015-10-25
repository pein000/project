package com.one.shop.repository;

import com.one.shop.entity.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pein on 2015/10/13.
 */
@Repository
@Transactional
public interface CarRepository extends CrudRepository<CarEntity,Integer> {
    public CarEntity findByUserId(int userId);

    public CarEntity findByUserIdAndGoodsIdAndActive(int userId, int goodsId,String active);

    public void deleteById(int id);
}
