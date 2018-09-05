package com.springboot.eshop.service.impl;

import com.springboot.eshop.dao.CartMapper;
import com.springboot.eshop.po.Cart;
import com.springboot.eshop.po.CartTotal;
import com.springboot.eshop.po.ProductInCart;
import com.springboot.eshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    public CartServiceImpl() {
    }

    public Integer saveOrUpdate(Integer mid, Integer pid, Integer quantity) {
        Cart byMidAndPid = this.cartMapper.queryByMidAndPid(mid, pid);
        return byMidAndPid == null ? this.cartMapper.doInsert(new Cart(mid, pid, quantity)) : this.cartMapper.updateQuantity(byMidAndPid.getId(), quantity);
    }

    public Map<String, Object> getByMid(Integer mid) {
        List<ProductInCart> carts = this.cartMapper.queryByMid(mid);
        CartTotal total = this.cartMapper.queryTotal(mid);
        Map<String, Object> map = new HashMap();
        map.put("carts", carts);
        map.put("total", total);
        return map;
    }

    public CartTotal minus(Integer mid, Integer id) {
        Integer minus = this.cartMapper.minus(mid, id);
        return minus == 1 ? this.cartMapper.queryTotal(mid) : null;
    }

    public CartTotal plus(Integer mid, Integer id) {
        Integer plus = this.cartMapper.plus(mid, id);
        return plus == 1 ? this.cartMapper.queryTotal(mid) : null;
    }

    public CartTotal delete(Integer mid, Integer id) {
        Integer delete = this.cartMapper.doDelete(mid, id);
        return delete == 1 ? this.cartMapper.queryTotal(mid) : null;
    }
}
