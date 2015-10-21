package com.one.shop.enums;

/**
 * Created by pein on 2015/10/20.
 * 积分账户的积分类型
 */
public enum PointType {

    ADD("获得积分"),
    SUB("扣减积分");

    private String description;

    PointType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
