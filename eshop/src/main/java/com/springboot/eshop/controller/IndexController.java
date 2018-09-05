package com.springboot.eshop.controller;

import com.springboot.eshop.po.Nav;
import com.springboot.eshop.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Set;

@Controller
public class IndexController {
    @Autowired
    private NavService navService;

    public IndexController() {
    }

    @RequestMapping({"/index"})
    public String index(Map<String, Object> map) {
        Set<Nav> nav = this.navService.getNav();
        map.put("nav", nav);
        return "index";
    }
}
