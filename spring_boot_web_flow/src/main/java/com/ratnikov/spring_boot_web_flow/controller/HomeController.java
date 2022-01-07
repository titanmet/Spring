package com.ratnikov.spring_boot_web_flow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome,in Web Flow!");
        return "index";
    }
}
