package com.one.shop.check;

import java.math.BigDecimal;

/**
 * Created by pein on 2015/10/24.
 */
public class AmountCheck {

    /**
     * 活动金额是否足额
     * @param activeAmount
     * @param totalAmount
     * @return
     */
    public static boolean enough(BigDecimal activeAmount, BigDecimal totalAmount) {
        if(moreZERO(activeAmount) && moreZERO(totalAmount)) {
            return activeAmount.compareTo(totalAmount) <= 0;
        }
        return false;
    }

    public static boolean enough(BigDecimal activeAmount) {
        return activeAmount.compareTo(BigDecimal.ZERO) > 0;
    }

    private static boolean moreZERO(BigDecimal amount){
        return amount.compareTo(BigDecimal.ZERO) > 0;
    }


}
