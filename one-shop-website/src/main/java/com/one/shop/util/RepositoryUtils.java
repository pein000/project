package com.one.shop.util;

import java.math.BigDecimal;

/**
 * Created by pein on 2015/10/25.
 */
public class RepositoryUtils {

    public static String resolveNullToString(Object value){
        return value==null?null:String.valueOf(value);
    }

    public static int resolveNullToInteger(Object value){
        return value==null?null:Integer.parseInt(String.valueOf(value));
    }

    public static BigDecimal resolveNullToBigDecimal(Object value){
        return value==null?null:new BigDecimal(String.valueOf(value));
    }
}
