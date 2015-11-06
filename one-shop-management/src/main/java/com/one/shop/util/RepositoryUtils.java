package com.one.shop.util;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.StringPath;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

/**
 * Created by pein on 2015/11/1.
 */
public class RepositoryUtils {

    public static Predicate getEqualExpression(String propertyValue, StringPath path) {
        return StringUtils.isEmpty(propertyValue) ? null : path.eq(propertyValue);
    }

    public static Predicate getGreaterExpression(String propertyValue, StringPath path) {
        return StringUtils.isEmpty(propertyValue) ? null : path.gt(propertyValue);
    }

    public static Predicate getLessEqualExpression(String propertyValue, StringPath path) {
        return StringUtils.isEmpty(propertyValue) ? null : path.lt(propertyValue).or(path.eq(propertyValue));
    }

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
