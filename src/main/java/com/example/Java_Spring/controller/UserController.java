package com.example.Java_Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Java_Spring.service.UserService;

// => MVC: Nó hơi lỗi bởi vì ta chưa có view
@Controller
public class UserController {

    @RequestMapping("/")
    public String getHomePage() {
        return "home.html";
    }

}

// => RESTful API: Sửa được lỗi MVC khi không có view
// @RestController
// public class UserController {
    
//     /*
//         @Autowired: cái này để không cần generate contructor,
//         nhưng mà không nên dùng
//     */
//     // => Đây chính là dependency injection
//     private UserService userService;
    
//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     @GetMapping("/")
//     public String getHomePage() {
//         return this.userService.handleHello();
//     }

// }