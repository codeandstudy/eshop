package com.springboot.eshop.dao;

import com.springboot.eshop.po.Category;

import java.util.List;
import java.util.Map;

public interface CategoryMapper {

    List<Map<String, Object>> query(Map<String, Object> param);

    Integer getCount(Map<String, Object> param);

    Integer doInsert(Category category);

    Integer doUpdate(Category category);

    Category queryByName(String name);

    List<Category> queryAll();
}
