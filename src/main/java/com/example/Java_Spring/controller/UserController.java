package com.example.Java_Spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Java_Spring.domain.User;
import com.example.Java_Spring.repository.UserRepository;
import com.example.Java_Spring.service.UserService;

// => MVC: Nó hơi lỗi bởi vì ta chưa có view
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUsers = this.userService.getAllUsersByEmail("abc_1@gmail.com");
        System.out.println(arrUsers);
        User user = this.userService.getUserByEmailOrAddress("abc_1@gmail.com", "abc");
        System.out.println(user);
        model.addAttribute("kienduy", "Kiến Duy");
        return "Home";
    }

    @RequestMapping(value = "/admin/user")
    public String getAdminUserPage() {
        return "Admin/User/Home";
    }

    @RequestMapping(value = "/admin/user/create")
    public String createUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "Admin/User/Create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute("newUser") User user) {
        this.userService.handleSaveUser(user);
        return "Home";
    }
}