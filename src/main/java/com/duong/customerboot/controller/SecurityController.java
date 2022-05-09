package com.duong.customerboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {
    @GetMapping("/user")
    public ModelAndView userPage(){
        return new ModelAndView("/user");
    }

    @GetMapping("/admin")
    public ModelAndView adminPage() {
        return new ModelAndView("/admin");
    }

    @GetMapping("/")
    public ModelAndView showIndexPage() {
        return new ModelAndView("/index");
    }
}
