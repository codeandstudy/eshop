package com.springboot.eshop.po;

public class ProductInCart {

    private Integer id;
    private Integer pid;
    private Integer cid;
    private String cname;
    private Integer bid;
    private String bname;
    private String name;
    private Double price;
    private String imgUrl;
    private Integer quantity;

    public ProductInCart() {
    }

    public String toString() {
        return "ProductInCart{id=" + this.id + ", pid=" + this.pid + ", cid=" + this.cid + ", cname='" + this.cname + '\'' + ", bid=" + this.bid + ", bname='" + this.bname + '\'' + ", name='" + this.name + '\'' + ", price=" + this.price + ", imgUrl='" + this.imgUrl + '\'' + ", quantity=" + this.quantity + '}';
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return this.cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getBid() {
        return this.bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return this.bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
