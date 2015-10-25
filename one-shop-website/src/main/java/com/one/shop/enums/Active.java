package com.one.shop.enums;

/**
 * Created by pein on 2015/10/21.
 */
public enum Active {
    TRUE("1","活动的"),
    FALSE("0","关闭的");

    private String code;

    private String description;

    Active(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
