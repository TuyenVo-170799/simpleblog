package com.javaweb.simpleblog.controller.admin;

import com.javaweb.simpleblog.dto.PostDTO;
import com.javaweb.simpleblog.service.ICategoryService;
import com.javaweb.simpleblog.service.IPostService;
import com.javaweb.simpleblog.validation.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "postControllerOfAdmin")
@RequestMapping(value = "/admin")
public class PostController {

    @Autowired
    private IPostService postService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private PostValidator postValidator;

    @GetMapping(value = {"/add"})
    public String addPage(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("post", new PostDTO());
        return "/admin/add_post";
    }

    @PostMapping(value = {"/add"})
    public String addPage(@ModelAttribute("post") PostDTO postDTO, BindingResult bindingResult, Model model) {
        postValidator.validate(postDTO, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "/admin/add_post";
        }
        postService.save(postDTO);
        return "/admin/list_post";
    }
    
    @GetMapping(value = {"/list"})
    public String listPage(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "/admin/list_post";
    }
}
