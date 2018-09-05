package com.springboot.eshop.dao;

import com.springboot.eshop.po.Member;

import java.util.List;

public interface MemberMapper {

    Member queryOne(Member member);

    List<Member> query(Member member);

    Integer doInsert(Member member);
}
