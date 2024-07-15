package com.example.Java_Spring.controller;

import java.net.Authenticator.RequestorType;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Java_Spring.domain.User;
import com.example.Java_Spring.repository.UserRepository;
import com.example.Java_Spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    public String getAdminUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "Admin/User/Home";
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

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String handleCreateUser(Model model, @ModelAttribute("newUser") User user) {
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