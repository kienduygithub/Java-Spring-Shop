package com.example.Java_Spring.controller.Client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping(value = "/")
    public String getHomePage() {
        return "Client/HomePage/Show";
    }
}
