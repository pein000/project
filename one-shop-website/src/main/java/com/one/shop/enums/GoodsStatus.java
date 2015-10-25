package com.one.shop.enums;

/**
 * Created by pein on 2015/10/25.
 */
public enum GoodsStatus {
    INIT("0","初始化"),
    ING("1","正在揭晓"),
    REVEAL("2","已经揭晓");

    private String code;
    private String description;

    GoodsStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
