package com.example.Java_Spring.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.Java_Spring.domain.Product;

@Controller
public class ProductController {
    
    @GetMapping(value = "/admin/product")
    public String getProductPage() {
        return "Admin/Product/Show";
    }

    @GetMapping(value = "/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "Admin/Product/Create";
    }

    @PostMapping(value = "/admin/product/create")
    public String handleCreateProduct(Model model, @ModelAttribute("newProduct") Product product, @RequestParam("imgProductFile") MultipartFile file) {
        
        return "redirect:/admin/product";
    }
}
