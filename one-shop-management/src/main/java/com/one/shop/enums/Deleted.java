package com.one.shop.enums;

/**
 * Created by pein on 2015/11/19.
 */
public enum Deleted {
    NONE("未删除"),
    Deleted("已删除");

    private String description;

    Deleted(String description) {
        this.description = description;
    }
}
