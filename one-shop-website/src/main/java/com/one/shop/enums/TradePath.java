package com.one.shop.enums;

/**
 * Created by pein on 2015/10/20.
 * 现金账户的交易途径
 */
public enum TradePath {

    ALIPAY("支付宝"),
    WECHATPAY("微信支付"),
    CASHPAY("现金账户支付"),
    OTHERS("其他途径");


    private String description;

    TradePath(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
