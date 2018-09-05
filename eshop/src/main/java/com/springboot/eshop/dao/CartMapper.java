package com.springboot.eshop.dao;

import com.springboot.eshop.po.Cart;
import com.springboot.eshop.po.CartTotal;
import com.springboot.eshop.po.ProductInCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {

    Integer doInsert(Cart cart);

    Cart queryByMidAndPid(@Param("mid") Integer mid, @Param("pid") Integer pid);

    Integer updateQuantity(@Param("id") Integer id, @Param("quantity") Integer quantity);

    List<ProductInCart> queryByMid(Integer mid);

    CartTotal queryTotal(Integer mid);

    Integer minus(@Param("mid") Integer mid, @Param("id") Integer id);

    Integer plus(@Param("mid") Integer mid, @Param("id") Integer id);

    Integer doDelete(@Param("mid") Integer mid, @Param("id") Integer id);

    Integer deleteAll(Integer mid);
}
