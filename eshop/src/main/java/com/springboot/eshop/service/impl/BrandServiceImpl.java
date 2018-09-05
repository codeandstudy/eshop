package com.springboot.eshop.service.impl;

import com.springboot.eshop.dao.BrandMapper;
import com.springboot.eshop.po.Brand;
import com.springboot.eshop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("brandService")
public class BrandServiceImpl implements BrandService {

    private static final double PAGE_SIZE = 8.0D;
    @Autowired
    private BrandMapper brandMapper;

    public BrandServiceImpl() {
    }

    public Map<String, Object> getBrands(Map<String, Object> param) {
        List<Map<String, Object>> brands = this.brandMapper.query(param);
        Integer count = this.brandMapper.getCount(param);
        param.put("brands", brands);
        param.put("count", count);
        param.put("pageNum", (int) Math.ceil((double) count / 8.0D));
        return param;
    }

    public Integer saveOrUpdate(Brand brand) {
        Brand byName = this.brandMapper.queryByName(brand.getName());
        if (byName != null && !byName.getBid().equals(brand.getBid())) {
            return null;
        } else {
            return brand.getBid() == null ? this.brandMapper.doInsert(brand) : this.brandMapper.doUpdate(brand);
        }
    }

    public List<Brand> queryAll() {
        return this.brandMapper.queryAll();
    }
}

