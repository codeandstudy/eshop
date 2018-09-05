package com.springboot.eshop.po;

public class Cart {

    private Integer id;
    private Integer mid;
    private Integer pid;
    private Integer quantity;

    public Cart() {
    }

    public Cart(Integer mid, Integer pid, Integer quantity) {
        this.mid = mid;
        this.pid = pid;
        this.quantity = quantity;
    }

    public String toString() {
        return "Cart{id=" + this.id + ", mid=" + this.mid + ", pid=" + this.pid + ", quantity=" + this.quantity + '}';
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return this.mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
