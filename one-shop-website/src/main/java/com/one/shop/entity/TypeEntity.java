package com.one.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by pein on 2015/10/13.
 */
@Entity()
@Table(name="one_shop_type")
public class TypeEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "URL")
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
