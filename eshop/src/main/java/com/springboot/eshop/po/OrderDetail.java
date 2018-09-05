package com.springboot.eshop.po;

public class OrderDetail {

    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Double price;

    public OrderDetail() {
    }

    public String toString() {
        return "OrderDetail{id=" + this.id + ", orderId=" + this.orderId + ", productId=" + this.productId + ", quantity=" + this.quantity + ", price=" + this.price + '}';
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
