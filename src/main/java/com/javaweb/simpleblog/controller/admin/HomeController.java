package com.javaweb.simpleblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "ControllerOfAdmin")
@RequestMapping(value = "/admin")
public class HomeController {

    @GetMapping(value = {"/", "home"})
    public String homePage() {
        return "/admin/home";
    }

}
