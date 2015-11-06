package com.one.shop.repository;

import com.one.shop.entity.NewGoods;
import com.one.shop.entity.QNewGoods;
import com.one.shop.repository.basic.QuerydslRepository;
import org.springframework.stereotype.Controller;

/**
 * Created by pein on 2015/11/5.
 */
@Controller
public class NewQueryDslRepository extends QuerydslRepository<NewGoods> {

    private QNewGoods qNewGoods = QNewGoods.newGoods;

    public NewQueryDslRepository() {
        super(NewGoods.class);
    }

    public void deleteAll() {
        this.delete(qNewGoods).execute();
    }

}
