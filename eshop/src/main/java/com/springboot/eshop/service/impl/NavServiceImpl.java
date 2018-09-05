package com.springboot.eshop.service.impl;

import com.springboot.eshop.dao.NavMapper;
import com.springboot.eshop.po.Nav;
import com.springboot.eshop.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("navService")
public class NavServiceImpl implements NavService {

    @Autowired
    private NavMapper navMapper;

    public NavServiceImpl() {
    }

    public Set<Nav> getNav() {
        return this.navMapper.queryNav();
    }
}