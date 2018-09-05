package com.springboot.eshop.service.impl;

import com.springboot.eshop.dao.MemberMapper;
import com.springboot.eshop.po.Member;
import com.springboot.eshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public MemberServiceImpl() {
    }

    public Member login(String name, String pass) {
        Member member = new Member();
        member.setName(name);
        member.setPass(pass);
        return this.memberMapper.queryOne(member);
    }

    public Map<String, Object> register(String name, String pass) {
        Map<String, Object> map = new HashMap();
        Member member = new Member();
        member.setName(name);
        Member registerMember = this.memberMapper.queryOne(member);
        if (registerMember != null) {
            map.put("error", "用户名已经存在");
        } else {
            member.setPass(pass);
            Integer integer = this.memberMapper.doInsert(member);
            if (integer == 1) {
                map.put("success", true);
            } else {
                map.put("error", "未知错误");
            }
        }

        return map;
    }
}

