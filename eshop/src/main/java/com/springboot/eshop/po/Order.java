package com.springboot.eshop.po;

import java.sql.Timestamp;

public class Order {

    private Integer id;
    private Integer memberId;
    private Integer addressId;
    private Timestamp createTime;

    public Order() {
    }

    public String toString() {
        return "Order{id=" + this.id + ", memberId=" + this.memberId + ", addressId=" + this.addressId + ", createTime=" + this.createTime + '}';
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return this.memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getAddressId() {
        return this.addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
