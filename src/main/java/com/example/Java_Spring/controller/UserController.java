package com.example.Java_Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Java_Spring.service.UserService;

// => MVC: Nó hơi lỗi bởi vì ta chưa có view
@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        model.addAttribute("kienduy", "Kiến Duy");
        model.addAttribute("thaiduy", "Thái Duy");
        return "Home";
    }

    @RequestMapping("/admin/user")
    public String createUserPage(Model model) {
        return "Admin/User/Create";
    }
}