package com.springboot.eshop.po;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

    private List<T> products;
    private int count;
    private int pageCount;
    private int page;

    public Page() {
    }

    public String toString() {
        return "Page{products=" + this.products + ", count=" + this.count + ", pageCount=" + this.pageCount + ", page=" + this.page + '}';
    }

    public List<T> getProducts() {
        return this.products;
    }

    public void setProducts(List<T> products) {
        this.products = products;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
