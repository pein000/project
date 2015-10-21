package com.one.shop.enums;

/**
 * Created by pein on 2015/10/20.
 * 积分账户的收入来源
 */
public enum IncomePath {

    SHOPPINGAWARD("购物奖赏"),
    FRIENDAWARD("邀请好友奖赏"),
    GAMEAWARD("游戏奖赏"),
    SHOPPINGOFFSET("购物冲抵"),
    GAMEOFFSET("游戏消费"),
    OTHERS("其他途径");


    private String description;

    IncomePath(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
