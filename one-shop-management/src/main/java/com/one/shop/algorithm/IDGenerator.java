package com.one.shop.algorithm;

/**
 * Created by pein on 2015/11/5.
 */
public class IDGenerator {
    private static int VALUE_ID_FIRST = 10000;

    public static int increment() {
        return VALUE_ID_FIRST++;
    }

    public static void clear() {
        VALUE_ID_FIRST = 10000;
    }
}
