package com.springboot.eshop.controller;

import com.springboot.eshop.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/profile"})
public class ProfileController {
    @Autowired
    private NavService navService;

    public ProfileController() {
    }

    @RequestMapping
    public String main(Model model) {
        model.addAttribute("nav", this.navService.getNav());
        return "profile";
    }
}
