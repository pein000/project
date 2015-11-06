package com.one.shop.repository;

import com.one.shop.entity.HotGoods;
import com.one.shop.entity.QHotGoods;
import com.one.shop.repository.basic.QuerydslRepository;
import org.springframework.stereotype.Controller;

/**
 * Created by pein on 2015/11/5.
 */
@Controller
public class HotQueryDslRepository extends QuerydslRepository<HotGoods> {

    private QHotGoods qHotGoods = QHotGoods.hotGoods;

    public HotQueryDslRepository() {
        super(HotGoods.class);
    }

    public void deleteAll() {
        this.delete(qHotGoods).execute();
    }

}
