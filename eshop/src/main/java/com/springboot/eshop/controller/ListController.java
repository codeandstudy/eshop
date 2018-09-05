package com.springboot.eshop.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.eshop.po.Nav;
import com.springboot.eshop.po.Page;
import com.springboot.eshop.po.Product;
import com.springboot.eshop.service.NavService;
import com.springboot.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class ListController {
    @Autowired
    private ProductService productService;
    @Autowired
    private NavService navService;

    public ListController() {
    }

    @RequestMapping({"/list"})
    public String list(@RequestParam(required = false, defaultValue = "1") Integer page, String cid, String bid, String name, Model model) {
        Page<Product> productPage = this.productService.query(cid, bid, name, page);
        Set<Nav> nav = this.navService.getNav();
        model.addAttribute("products", productPage.getProducts());
        model.addAttribute("pageCount", productPage.getPageCount());
        model.addAttribute("page", page);
        model.addAttribute("nav", nav);
        return "list";
    }

    @RequestMapping({"/product/{pid}"})
    public String product(@PathVariable Integer pid, Model model) {
        Product product = this.productService.get(pid);
        System.out.println(JSON.toJSONString(product));
        Set<Nav> nav = this.navService.getNav();
        model.addAttribute("product", product);
        model.addAttribute("nav", nav);
        return "product";
    }
}
