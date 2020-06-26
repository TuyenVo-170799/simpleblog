package com.javaweb.simpleblog.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping(value = {"/detail"})
    public String detailPage() {
        return "/web/detail_post";
    }
}
