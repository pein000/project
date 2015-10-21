package com.one.shop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pein on 2015/10/21.
 */
public class DateUtils {
    private static final String DEFAULT_TEMPLATE = "yyyyMMdd" ;

    public static Date parse(String source) {
        try {
            return new SimpleDateFormat(DEFAULT_TEMPLATE).parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("parse time error.");
        }
    }
}
