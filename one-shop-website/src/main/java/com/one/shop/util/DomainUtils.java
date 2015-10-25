package com.one.shop.util;

import com.one.shop.domain.Car;
import com.one.shop.domain.User;
import com.one.shop.enums.Active;

/**
 * Created by pein on 2015/10/25.
 */
public class DomainUtils {

    public static Car getActiveCarInstance(int goodsId, int quantity, User user) {
        Car car = new Car();
        car.setGoodsId(goodsId);
        car.setQuantity(quantity);
        car.setActive(Active.TRUE.getCode());
        car.setUserId(user.getId());

        return car;
    }
}
