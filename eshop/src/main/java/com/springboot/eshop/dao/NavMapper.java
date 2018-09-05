package com.springboot.eshop.dao;

import com.springboot.eshop.po.Nav;

import java.util.LinkedHashSet;

public interface NavMapper {

    LinkedHashSet<Nav> queryNav();
}
