package com.example.Java_Spring.controller.Client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Java_Spring.domain.Product;
import com.example.Java_Spring.service.ProductService;

@Controller
public class ItemController {
    
    private final ProductService productService;

    public ItemController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/{id}")
    public String getDetailProductPage(Model model, @PathVariable("id") long id) {
        Product product = this.productService.findProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "Client/Product/Detail";
    }

}
