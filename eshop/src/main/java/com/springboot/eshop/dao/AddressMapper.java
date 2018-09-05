package com.springboot.eshop.dao;

import com.springboot.eshop.po.Address;

import java.util.List;

public interface AddressMapper {

    List<Address> queryByMid(Integer mid);

    int doInsert(Address address);

    int doUpdate(Address address);
}
