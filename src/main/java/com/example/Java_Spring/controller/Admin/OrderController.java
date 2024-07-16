package com.example.Java_Spring.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    
    @GetMapping(value = "/admin/order")
    public String getDashboard() {
        return "Admin/Order/Show";
    }

}
