package com.springboot.eshop.service;

import com.springboot.eshop.po.Member;

import java.util.Map;

public interface MemberService {

    Member login(String name, String pass);

    Map<String, Object> register(String name, String pass);
}
