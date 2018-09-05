package com.springboot.eshop.po;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class Nav extends Category implements Serializable {

    private LinkedHashSet<Brand> brands;

    public Nav() {
    }

    public String toString() {
        return "Nav{brands=" + this.brands + '}';
    }

    public LinkedHashSet<Brand> getBrands() {
        return this.brands;
    }

    public void setBrands(LinkedHashSet<Brand> brands) {
        this.brands = brands;
    }
}
