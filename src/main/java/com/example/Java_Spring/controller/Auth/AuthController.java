package com.example.Java_Spring.controller.Auth;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Java_Spring.domain.Role;
import com.example.Java_Spring.domain.User;
import com.example.Java_Spring.domain.DTO.RegisterDTO;
import com.example.Java_Spring.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {
    
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "Client/Auth/Register";
    }

    @PostMapping(value = "/register")
    public String handleRegister(
        @ModelAttribute("registerUser") @Valid RegisterDTO registerUser,
            BindingResult registerUserBindingResult
    ) {
        
        List<FieldError> errors = registerUserBindingResult.getFieldErrors();

        System.out.println("=====================================");
        for (FieldError error : errors) {
            System.out.println(">>> " + error.getField() + " - " + error.getDefaultMessage());
        }

        if (registerUserBindingResult.hasErrors())
            return "Client/Auth/Register";
        
        User user = this.userService.registerDTOtoUser(registerUser);
        String hashedPassword = this.passwordEncoder.encode(user.getPassword());
        String roleName = "USER";
        Role role = this.userService.getRoleByName(roleName);
        user.setPassword(hashedPassword);
        user.setRole(role);
        this.userService.handleSaveUser(user);
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "Client/Auth/Login";
    }
}
