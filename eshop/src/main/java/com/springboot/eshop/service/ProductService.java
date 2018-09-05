package com.springboot.eshop.service;

import com.springboot.eshop.po.Page;
import com.springboot.eshop.po.Product;

public interface ProductService {

    Page<Product> query(String cid, String bid, String name, int page);

    Product get(Integer pid);

    Integer saveOrUpdate(Product product);
}
