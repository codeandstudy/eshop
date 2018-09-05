package com.springboot.eshop.po;

public class CartTotal {

    private Integer totalCount;
    private Double totalPrice;

    public CartTotal() {
    }

    public String toString() {
        return "CartTotal{totalCount=" + this.totalCount + ", totalPrice=" + this.totalPrice + '}';
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
