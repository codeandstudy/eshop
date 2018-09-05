package com.springboot.eshop.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.springboot.eshop.dao.ProductMapper;
import com.springboot.eshop.po.Page;
import com.springboot.eshop.po.Product;
import com.springboot.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    public ProductServiceImpl() {
    }

    public Page<Product> query(String cid, String bid, String name, int page) {
        Page<Product> productPage = new Page();
        Map<String, Object> param = new HashMap();
        if (!StringUtils.isEmpty(cid)) {
            param.put("cid", cid);
        }

        if (!StringUtils.isEmpty(bid)) {
            param.put("bid", bid);
        }

        if (!StringUtils.isEmpty(name)) {
            param.put("name", name);
        }

        PageHelper.startPage(page, 12);
        List<Product> products = this.productMapper.query(param);
        long count = PageHelper.count(() -> {
            this.productMapper.query(param);
        });
        productPage.setProducts(products);
        productPage.setCount((int) count);
        productPage.setPage(page);
        int pageCount = (int) Math.ceil((double) count / 12.0D);
        productPage.setPageCount(pageCount);
        return productPage;
    }

    public Product get(Integer pid) {
        return this.productMapper.queryById(pid);
    }

    public Integer saveOrUpdate(Product product) {
        System.out.println(JSON.toJSONString(product));
        return product.getPid() == null ? this.productMapper.doInsert(product) : this.productMapper.doUpdate(product);
    }
}
