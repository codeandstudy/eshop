package com.springboot.eshop.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Brand implements Serializable {

    private Integer bid;
    private String name;
    private Integer status;
    private Timestamp createTime;

    public Brand() {
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getBid() {
        return this.bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
