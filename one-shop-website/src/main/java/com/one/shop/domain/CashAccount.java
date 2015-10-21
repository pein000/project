package com.one.shop.domain;

import java.math.BigDecimal;

/**
 * Created by pein on 2015/10/20.
 */
public class CashAccount {

    private int id;

    private int userId;

    private BigDecimal amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
