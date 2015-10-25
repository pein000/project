package com.one.shop.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by pein on 2015/10/20.
 */
@Entity()
@Table(name="one_account_cash")
public class CashAccountEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="USER_ID")
    private int userId;

    @Column(name = "AMOUNT")
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
