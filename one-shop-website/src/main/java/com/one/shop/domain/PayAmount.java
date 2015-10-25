package com.one.shop.domain;

import java.math.BigDecimal;

/**
 * Created by pein on 2015/10/24.
 */
public class PayAmount {

    private BigDecimal allAmount;

    private BigDecimal pointAmount;

    private BigDecimal cashAmount;

    private BigDecimal platformAmount;

    public BigDecimal getAllAmount() {
        return allAmount;
    }

    public void setAllAmount(BigDecimal allAmount) {
        this.allAmount = allAmount;
    }

    public BigDecimal getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(BigDecimal pointAmount) {
        this.pointAmount = pointAmount;
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public BigDecimal getPlatformAmount() {
        return platformAmount;
    }

    public void setPlatformAmount(BigDecimal platformAmount) {
        this.platformAmount = platformAmount;
    }
}
