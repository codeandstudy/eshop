package com.springboot.eshop.service.impl;

import com.springboot.eshop.dao.CategoryMapper;
import com.springboot.eshop.po.Category;
import com.springboot.eshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    private static final double PAGE_SIZE = 8.0D;
    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryServiceImpl() {
    }

    public Map<String, Object> getCategories(Map<String, Object> param) {
        List<Map<String, Object>> categories = this.categoryMapper.query(param);
        Integer count = this.categoryMapper.getCount(param);
        param.put("categories", categories);
        param.put("count", count);
        param.put("pageNum", (int) Math.ceil((double) count / 8.0D));
        return param;
    }

    public Integer saveOrUpdate(Category category) {
        Category byName = this.categoryMapper.queryByName(category.getName());
        if (byName != null && !byName.getCid().equals(category.getCid())) {
            return null;
        } else {
            return category.getCid() == null ? this.categoryMapper.doInsert(category) : this.categoryMapper.doUpdate(category);
        }
    }

    public List<Category> queryAll() {
        return this.categoryMapper.queryAll();
    }
}

