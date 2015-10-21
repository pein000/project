package com.one.shop.domain;

import com.one.shop.enums.TradePath;
import com.one.shop.enums.TradeType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by pein on 2015/10/20.
 */
public class CashFlow {

    private int id;

    private int cashId;

    private BigDecimal amount;

    private TradeType tradeType;

    private TradePath tradePath;

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
