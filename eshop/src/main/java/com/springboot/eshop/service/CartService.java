package com.springboot.eshop.service;

import com.springboot.eshop.po.CartTotal;

import java.util.Map;

public interface CartService {

    Integer saveOrUpdate(Integer mid, Integer pid, Integer quantity);

    Map<String, Object> getByMid(Integer mid);

    CartTotal minus(Integer mid, Integer id);

    CartTotal plus(Integer mid, Integer id);

    CartTotal delete(Integer mid, Integer id);
}
