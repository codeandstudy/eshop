package com.springboot.eshop.service.impl;

import com.springboot.eshop.dao.CartMapper;
import com.springboot.eshop.dao.OrderMapper;
import com.springboot.eshop.dao.ProductMapper;
import com.springboot.eshop.po.Order;
import com.springboot.eshop.po.OrderDetail;
import com.springboot.eshop.po.OrderList;
import com.springboot.eshop.po.ProductInCart;
import com.springboot.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    public OrderServiceImpl() {
    }

    @Transactional
    public int submit(Integer mid, Integer aid) {
        Order order = new Order();
        order.setMemberId(mid);
        order.setAddressId(aid);
        int result = this.orderMapper.doInsert(order);
        List<ProductInCart> productInCarts = this.cartMapper.queryByMid(mid);
        List<OrderDetail> orderDetails = new ArrayList();

        Integer pid;
        Integer quantity;
        for (Iterator var7 = productInCarts.iterator(); var7.hasNext(); result += this.productMapper.updateInventory(pid, quantity)) {
            ProductInCart productInCart = (ProductInCart) var7.next();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());
            pid = productInCart.getPid();
            orderDetail.setProductId(pid);
            quantity = productInCart.getQuantity();
            orderDetail.setQuantity(quantity);
            orderDetail.setPrice(productInCart.getPrice());
            orderDetails.add(orderDetail);
            result += this.productMapper.updateSalesVolume(pid, quantity);
        }

        result += this.orderMapper.doInsertDetail(orderDetails);
        result += this.cartMapper.deleteAll(mid);
        return result;
    }

    public List<OrderList> get(Integer mid) {
        return this.orderMapper.queryByMid(mid);
    }
}
