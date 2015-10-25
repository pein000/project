package com.one.shop.entity;

import com.one.shop.enums.TradePath;
import com.one.shop.enums.TradeType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by pein on 2015/10/20.
 */
@Entity()
@Table(name="one_cash_flow")
public class CashFlowEntity {

    @Id
    @Column(name="ID")
    private int id;

    @Column(name = "CASH_ID")
    private int cashId;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRADE_TYPE")
    private TradeType tradeType;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRADE_PATH")
    private TradePath tradePath;

    @Column(name = "TRADE_TIME")
    private String tradeTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getCashId() {
        return cashId;
    }

    public void setCashId(int cashId) {
        this.cashId = cashId;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public TradePath getTradePath() {
        return tradePath;
    }

    public void setTradePath(TradePath tradePath) {
        this.tradePath = tradePath;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }
}
