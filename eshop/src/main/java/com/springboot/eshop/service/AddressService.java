package com.springboot.eshop.service;

import com.springboot.eshop.po.Address;

import java.util.List;

public interface AddressService {

    List<Address> getByMid(Integer mid);
}
