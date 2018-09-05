package com.springboot.eshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.eshop.po.CartTotal;
import com.springboot.eshop.po.Member;
import com.springboot.eshop.po.Product;
import com.springboot.eshop.service.CartService;
import com.springboot.eshop.service.NavService;
import com.springboot.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping({"/cart"})
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private NavService navService;

    public CartController() {
    }

    @RequestMapping({"/add"})
    public String add(Model model, HttpSession session, Integer pid, Integer quantity) {
        System.out.println("pid = [" + pid + "], quantity = [" + quantity + "]");
        Member member = (Member) session.getAttribute("member");
        if (member == null) {
            return "redirect:/account";
        }
        Integer saveOrUpdate = this.cartService.saveOrUpdate(member.getMid(), pid, quantity);
        if (saveOrUpdate == 1) {
            Product product = this.productService.get(pid);
            model.addAttribute("product", product);
            model.addAttribute("quantity", quantity);
        }

        model.addAttribute("nav", this.navService.getNav());
//        return "result";


        Map<String, Object> result = this.cartService.getByMid(member.getMid());
        model.addAllAttributes(result).addAttribute("nav", this.navService.getNav());
        return "redirect:/cart/list";
    }

    @RequestMapping({"/list"})
    public String list(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("member");
        if (member == null) {
            return "redirect:/account";
        }
        Map<String, Object> result = this.cartService.getByMid(member.getMid());
        model.addAllAttributes(result).addAttribute("nav", this.navService.getNav());
        return "cart";
    }

    @ResponseBody
    @RequestMapping(
            value = {"/minus/{id}"},
            produces = {"application/json;charset=utf-8"}
    )
    public String minus(HttpSession session, @PathVariable Integer id) {
        Member member = (Member) session.getAttribute("member");
        CartTotal cartTotal = this.cartService.minus(member.getMid(), id);
        return this.cartTotal2Json(cartTotal);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/plus/{id}"},
            produces = {"application/json;charset=utf-8"}
    )
    public String plus(HttpSession session, @PathVariable Integer id) {
        Member member = (Member) session.getAttribute("member");
        CartTotal cartTotal = this.cartService.plus(member.getMid(), id);
        return this.cartTotal2Json(cartTotal);
    }

//    @ResponseBody
    @RequestMapping(
            value = {"/delete/{id}"},
            produces = {"application/json;charset=utf-8"}
    )
    public String delete(HttpSession session, @PathVariable Integer id,Model model) {
        Member member = (Member) session.getAttribute("member");
        CartTotal cartTotal = this.cartService.delete(member.getMid(), id);
//        return this.cartTotal2Json(cartTotal);

        if (member == null) {
            return "account";
        }
        Map<String, Object> result = this.cartService.getByMid(member.getMid());
        model.addAllAttributes(result).addAttribute("nav", this.navService.getNav());
        return "redirect:/cart/list";
    }

    private String cartTotal2Json(CartTotal cartTotal) {
        JSONObject jsonObject = new JSONObject();
        if (cartTotal != null) {
            jsonObject.put("success", true);
            jsonObject.put("total", cartTotal);
        } else {
            jsonObject.put("success", false);
            jsonObject.put("reason", "未知错误");
        }

        return jsonObject.toJSONString();
    }
}
