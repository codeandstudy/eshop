package com.springboot.eshop.dao;

import com.springboot.eshop.po.Brand;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    List<Map<String, Object>> query(Map<String, Object> param);

    Integer getCount(Map<String, Object> param);

    Integer doInsert(Brand brand);

    Integer doUpdate(Brand brand);

    Brand queryByName(String name);

    List<Brand> queryAll();
}
