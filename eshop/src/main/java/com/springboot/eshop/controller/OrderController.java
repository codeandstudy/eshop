package com.springboot.eshop.controller;

import com.springboot.eshop.po.Member;
import com.springboot.eshop.po.OrderList;
import com.springboot.eshop.service.NavService;
import com.springboot.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping({"/order"})
public class OrderController {
    @Autowired
    private NavService navService;
    @Autowired
    private OrderService orderService;

    public OrderController() {
    }

    @RequestMapping
    public String main(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("member");
        List<OrderList> orders = this.orderService.get(member.getMid());
        model.addAttribute("orders", orders);
        model.addAttribute("nav", this.navService.getNav());
        return "order";
    }
}

