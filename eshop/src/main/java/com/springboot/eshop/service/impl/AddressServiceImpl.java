package com.springboot.eshop.service.impl;

import com.springboot.eshop.dao.AddressMapper;
import com.springboot.eshop.po.Address;
import com.springboot.eshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    public AddressServiceImpl() {
    }

    public List<Address> getByMid(Integer mid) {
        return this.addressMapper.queryByMid(mid);
    }
}
