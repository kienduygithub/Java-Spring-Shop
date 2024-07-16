package com.example.Java_Spring.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    
    @GetMapping(value = "/admin/product")
    public String getDashboard() {
        return "Admin/Product/Show";
    }

}
