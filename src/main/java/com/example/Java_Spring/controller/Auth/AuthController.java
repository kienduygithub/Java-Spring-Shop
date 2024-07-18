package com.example.Java_Spring.controller.Auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Java_Spring.domain.User;
import com.example.Java_Spring.domain.DTO.RegisterDTO;

@Controller
public class AuthController {
    
    @GetMapping(value = "/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "Client/Auth/Register";
    }

    @PostMapping(value = "/register")
    public String handleRegister(@ModelAttribute("registerUser") RegisterDTO registerUser) {
        System.out.println(">>> New user: " + registerUser);
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "Client/Auth/Login";
    }
}
