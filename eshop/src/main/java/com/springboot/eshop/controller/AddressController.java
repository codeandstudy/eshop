package com.springboot.eshop.controller;

import com.springboot.eshop.po.Address;
import com.springboot.eshop.po.Member;
import com.springboot.eshop.service.AddressService;
import com.springboot.eshop.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping({"/address"})
public class AddressController {

    @Autowired
    private NavService navService;
    @Autowired
    private AddressService addressService;

    public AddressController() {
    }

    @RequestMapping
    public String main(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("member");
        List<Address> addresses = this.addressService.getByMid(member.getMid());
        model.addAttribute("addresses", addresses);
        model.addAttribute("nav", this.navService.getNav());
        return "address";
    }
}
