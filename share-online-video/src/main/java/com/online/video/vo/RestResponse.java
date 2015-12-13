package com.online.video.vo;

import java.io.Serializable;

/**
 * Created by pein on 2015/12/10.
 */
public abstract class RestResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private String successCode;

    private String successRemark;

    public String getSuccessCode() {
        return successCode;
    }

    public void setSuccessCode(String successCode) {
        this.successCode = successCode;
    }

    public String getSuccessRemark() {
        return successRemark;
    }

    public void setSuccessRemark(String successRemark) {
        this.successRemark = successRemark;
    }
}
