package com.springboot.eshop.po;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

public class OrderList {

    private Integer id;
    private Timestamp createTime;
    private Address address;
    private List<ProductInCart> products;
    private Double totalPrice;

    public OrderList() {
    }

    public String toString() {
        return "OrderList{id=" + this.id + ", createTime=" + this.createTime + ", address=" + this.address + ", products=" + this.products + ", totalPrice=" + this.totalPrice + '}';
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ProductInCart> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductInCart> products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        BigDecimal bigDecimal = new BigDecimal(0.0D);

        ProductInCart product;
        for (Iterator var2 = this.products.iterator(); var2.hasNext(); bigDecimal = bigDecimal.add((new BigDecimal(String.valueOf(product.getPrice()))).multiply(new BigDecimal(String.valueOf(product.getQuantity()))))) {
            product = (ProductInCart) var2.next();
        }

        return bigDecimal.doubleValue();
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
