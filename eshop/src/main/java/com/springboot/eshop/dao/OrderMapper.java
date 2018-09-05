package com.springboot.eshop.dao;

import com.springboot.eshop.po.Order;
import com.springboot.eshop.po.OrderDetail;
import com.springboot.eshop.po.OrderList;

import java.util.List;

public interface OrderMapper {

    int doInsert(Order order);

    int doInsertDetail(List<OrderDetail> orderDetails);

    List<OrderList> queryByMid(Integer mid);
}
