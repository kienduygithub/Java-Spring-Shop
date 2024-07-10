package com.example.Java_Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Java_Spring.service.UserService;

// => MVC: Nó hơi lỗi
// @Controller
// public class UserController {
    
//     @RequestMapping("/")
//     public String getHomePage() {
//         return "Home Page from Controller";
//     }

// }
// => RESTful API: Sửa được lỗi
@RestController
public class UserController {
    
    /*
        @Autowired: cái này để không cần generate contructor,
        nhưng mà không nên dùng
    */ 
    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return this.userService.handleHello();
    }

}