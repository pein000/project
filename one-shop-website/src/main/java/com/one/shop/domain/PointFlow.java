package com.one.shop.domain;

import com.one.shop.enums.IncomePath;
import com.one.shop.enums.PointType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by pein on 2015/10/20.
 */
public class PointFlow {

    private int id;

    private int pointId;

    private BigDecimal amount;

    private IncomePath incomePath;

    private PointType pointType;

    private String pointTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public IncomePath getIncomePath() {
        return incomePath;
    }

    public void setIncomePath(IncomePath incomePath) {
        this.incomePath = incomePath;
    }

    public PointType getPointType() {
        return pointType;
    }

    public void setPointType(PointType pointType) {
        this.pointType = pointType;
    }

    public String getPointTime() {
        return pointTime;
    }

    public void setPointTime(String pointTime) {
        this.pointTime = pointTime;
    }
}
