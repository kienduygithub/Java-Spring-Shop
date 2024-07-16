package com.example.Java_Spring.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    
    @GetMapping(value = "/admin")
    public String getDashboard() {
        return "Admin/Dashboard/Show";
    }

}
