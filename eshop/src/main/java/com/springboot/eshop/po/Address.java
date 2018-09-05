package com.springboot.eshop.po;

public class Address {

    private Integer aid;
    private String addr;
    private String name;
    private String tel;
    private Integer mid;
    private Integer isDefault;
    private Integer status;

    public Address() {
    }

    public String toString() {
        return "Address{aid=" + this.aid + ", addr='" + this.addr + '\'' + ", name='" + this.name + '\'' + ", tel='" + this.tel + '\'' + ", mid=" + this.mid + ", isDefault=" + this.isDefault + ", status=" + this.status + '}';
    }

    public Integer getAid() {
        return this.aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAddr() {
        return this.addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getMid() {
        return this.mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
