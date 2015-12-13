package com.one.shop.repository;

import com.one.shop.entity.QRevealedGoods;
import com.one.shop.entity.RevealedGoods;
import com.one.shop.repository.basic.QuerydslRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pein on 2015/11/16.
 */
@Repository
public class RevealedQueryDslRepository extends QuerydslRepository<RevealedGoods> {

    private static  final QRevealedGoods qRevealedGoods = QRevealedGoods.revealedGoods;

    public RevealedQueryDslRepository() {
        super(RevealedGoods.class);
    }

    public List<RevealedGoods> findAll() {
       return this.from(qRevealedGoods)
                .orderBy(qRevealedGoods.createTime.desc())
                .list(qRevealedGoods);
    }
}
