package com.one.shop.enums;

/**
 * Created by pein on 2015/10/20.
 * 现金账户的交易类型
 */

public enum TradeType {

    CHARGE("充值"),
    CONSUME("消费"),
    WITHDRAW("提现"),
    OTHERS("其他");

    private String description;

    TradeType( String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
