package com.springboot.eshop.service;

import com.springboot.eshop.po.OrderList;

import java.util.List;

public interface OrderService {

    int submit(Integer mid, Integer aid);

    List<OrderList> get(Integer mid);
}
