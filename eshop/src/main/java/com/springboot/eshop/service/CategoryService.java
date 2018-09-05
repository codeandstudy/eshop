package com.springboot.eshop.service;

import com.springboot.eshop.po.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    Map<String, Object> getCategories(Map<String, Object> param);

    Integer saveOrUpdate(Category category);

    List<Category> queryAll();
}
