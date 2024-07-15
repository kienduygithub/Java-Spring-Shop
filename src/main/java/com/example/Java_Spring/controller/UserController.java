package com.example.Java_Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Java_Spring.domain.User;
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
        String tryService = this.userService.handleHello();
        model.addAttribute("kienduy", "Kiến Duy");
        return "Home";
    }

    @RequestMapping("/admin/user") // GET
    public String createUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "Admin/User/Create";
    }

    @RequestMapping(value = "/admin/user/handle-create", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute("newUser") User user) {
        System.out.println("Run here: " + user.toString());
        return "Home";
    }
}