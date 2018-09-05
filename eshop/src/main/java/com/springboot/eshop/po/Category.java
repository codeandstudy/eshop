package com.springboot.eshop.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Category implements Serializable {

    private Integer cid;
    private String name;
    private Integer status;
    private Timestamp createTime;

    public Category() {
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

    public Integer getCid() {
        return this.cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
