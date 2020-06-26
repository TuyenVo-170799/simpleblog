package com.javaweb.simpleblog.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "home"})
    public String homePage() {

        return "/web/home";
    }
}
