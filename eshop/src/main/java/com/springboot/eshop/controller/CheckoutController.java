package com.springboot.eshop.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.eshop.po.Address;
import com.springboot.eshop.po.Member;
import com.springboot.eshop.service.AddressService;
import com.springboot.eshop.service.CartService;
import com.springboot.eshop.service.NavService;
import com.springboot.eshop.service.OrderService;
import com.springboot.eshop.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/checkout"})
public class CheckoutController {
    @Autowired
    private CartService cartService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private NavService navService;

    public CheckoutController() {
    }

    @RequestMapping
    public String main(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("member");
        if (member == null) {
            return "redirect:account";
        }
        Integer mid = member.getMid();
        Map<String, Object> products = this.cartService.getByMid(mid);
        List<Address> addresses = this.addressService.getByMid(mid);
        Map<String, Object> result = this.cartService.getByMid(member.getMid());
        model.addAllAttributes(result);
        model.addAttribute("products", products);
        model.addAttribute("addresses", addresses);
        model.addAttribute("nav", this.navService.getNav());
        return "checkout";
    }

    @RequestMapping(
            value = {"/submit"},
            produces = {"application/json;charset=utf-8"}
    )
    @ResponseBody
    public String submit(HttpSession session, Integer aid) {
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        int submit = this.orderService.submit(mid, aid);
        return submit > 0 ? JSON.toJSONString(R.ok()) : JSON.toJSONString(R.error());
    }
}
