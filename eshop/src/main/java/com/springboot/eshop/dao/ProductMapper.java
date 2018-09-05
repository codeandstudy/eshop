package com.springboot.eshop.dao;

import com.springboot.eshop.po.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    int PAGE_SIZE = 4;

    List<Product> query(Map<String, Object> param);

    Product queryById(Integer pid);

    Integer updateSalesVolume(@Param("pid") Integer pid, @Param("quantity") Integer quantity);

    Integer updateInventory(@Param("pid") Integer pid, @Param("quantity") Integer quantity);

    Integer doInsert(Product product);

    Integer doUpdate(Product product);
}
