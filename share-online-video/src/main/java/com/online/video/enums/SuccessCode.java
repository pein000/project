package com.online.video.enums;

/**
 * Created by pein on 2015/12/10.
 */
public enum SuccessCode {
    SUCCESS("成功"),
    PROCESS("执行中"),
    FAILURE("失败");

    private String remark;

    SuccessCode(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
