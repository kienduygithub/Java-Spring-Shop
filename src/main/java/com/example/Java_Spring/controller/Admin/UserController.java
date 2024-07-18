package com.example.Java_Spring.controller.Admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Java_Spring.domain.Role;
import com.example.Java_Spring.domain.User;
import com.example.Java_Spring.repository.UserRepository;
import com.example.Java_Spring.service.UploadService;
import com.example.Java_Spring.service.UserService;

import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// => MVC: Nó hơi lỗi bởi vì ta chưa có view
@Controller
public class UserController {

    private final UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadService uploadService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/admin/user")
    public String getAdminUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "Admin/User/Show";
    }

    @RequestMapping(value = "/admin/user/{userId}")
    public String getUserDetailPage(Model model, @PathVariable long userId) {
        User user = this.userService.getUserById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        return "Admin/User/Detail";
    }

    @RequestMapping(value = "/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "Admin/User/Create";
    }

    @PostMapping(value = "/admin/user/create")
    public String handleCreateUser(
        Model model,
        @Valid @ModelAttribute("newUser") User user,
        BindingResult newUserBindingResult,
        @RequestParam("avatarFile") MultipartFile file
    ) 
    {
        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        
        // Validate
        List<FieldError> errors = newUserBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>> " + error.getField() + " - " + error.getDefaultMessage());
        }
        if (newUserBindingResult.hasErrors()) {
            return "Admin/User/Create";
        }
        // After Validate
        user.setPassword(hashPassword);
        user.setAvatar(avatar);
        user.setRole(this.userService.getRoleByName(user.getRole().getName()));
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/update/{userId}")
    public String getUpdateUserPage(Model model, @PathVariable long userId) {
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("id", userId);
        return "Admin/User/Update";
    }

    @PostMapping(value = "/admin/user/update")
    public String handleUpdateUser(Model model, @ModelAttribute("user") User user) {
        User currentUser = this.userService.getUserById(user.getId());
        if (currentUser != null) {
            currentUser.setPhone(user.getPhone());
            currentUser.setAddress(user.getAddress());
            currentUser.setFullName(user.getFullName());
            currentUser.setRole(this.userService.getRoleByName(user.getRole().getName()));
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/delete/{userId}")
    public String getDeleteUserPage(Model model, @PathVariable long userId) {
        model.addAttribute("user", new User());
        model.addAttribute("id", userId);
        return "Admin/User/Delete";
    }

    @PostMapping(value = "/admin/user/delete")
    public String handleDeleteUser(Model model, @ModelAttribute("user") User user) {
        this.userService.deleteUserById(user.getId());
        return "redirect:/admin/user";
    }
}