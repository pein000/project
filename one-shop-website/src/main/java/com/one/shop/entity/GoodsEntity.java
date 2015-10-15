package com.one.shop.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by pein on 2015/10/13.
 */
@Entity()
@Table(name = "one_shop_goods")
public class GoodsEntity {

    @Id
    @Column(name="ID")
    private int id;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="OUTLINE_URL")
    private String outlineUrl;

    @Column(name="TYPE")
    private int type;

    @Column(name="PRICE")
    private BigDecimal price;

    @Column(name="TOTAL_AMOUNT")
    private int totalAmount;

    @Column(name="CUR_AMOUNT")
    private int curAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOutlineUrl() {
        return outlineUrl;
    }

    public void setOutlineUrl(String outlineUrl) {
        this.outlineUrl = outlineUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCurAmount() {
        return curAmount;
    }

    public void setCurAmount(int curAmount) {
        this.curAmount = curAmount;
    }
}
