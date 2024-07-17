package com.example.Java_Spring.controller.Client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {
    
    @GetMapping(value = "/product/{id}")
    public String getDetailProductPage(Model model, @PathVariable("id") long id) {
        return "Client/Product/Detail";
    }

}
