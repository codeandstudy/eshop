package com.springboot.eshop.controller;

import com.springboot.eshop.po.Member;
import com.springboot.eshop.service.MemberService;
import com.springboot.eshop.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping({"/account"})
public class AccountController {
    @Autowired
    private NavService navService;
    @Autowired
    private MemberService memberService;

    public AccountController() {
    }

    @RequestMapping
    public String main(Model model) {
        model.addAttribute("nav", this.navService.getNav());
        return "account";
    }

    @RequestMapping({"/login"})
    public String login(String name, String pass, @RequestParam(required = false, defaultValue = "/index") String callBack, HttpSession session) {
        Member member = this.memberService.login(name, pass);
        if (member != null) {
            session.setAttribute("member", member);
        }

        return "redirect:" + callBack;
    }

    @RequestMapping({"/logout"})
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
