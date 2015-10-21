package com.one.shop.entity;

import com.one.shop.enums.IncomePath;
import com.one.shop.enums.PointType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by pein on 2015/10/20.
 */
@Entity()
@Table(name="one_point_flow")
public class PointFlowEntity {
    @Id
    @Column(name="ID")
    private int id;

    @Column(name="POINT_ID")
    private int pointId;

    @Column(name="AMOUNT")
    private BigDecimal amount;

    @Column(name="INCOME_PATH")
    private IncomePath incomePath;

    @Column(name="POINT_TYPE")
    private PointType pointType;

    @Column(name="POINT_TIME")
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
