package com.one.shop.domain;

/**
 * Created by pein on 2015/10/24.
 */
public class PayData {

    private PayAmount payAmount;

    private PointAccount pointAccount;

    private CashAccount cashAccount;

    public PayAmount getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(PayAmount payAmount) {
        this.payAmount = payAmount;
    }

    public PointAccount getPointAccount() {
        return pointAccount;
    }

    public void setPointAccount(PointAccount pointAccount) {
        this.pointAccount = pointAccount;
    }

    public CashAccount getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(CashAccount cashAccount) {
        this.cashAccount = cashAccount;
    }
}


