package com.example.Java_Spring.controller.Admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.Java_Spring.domain.Product;
import com.example.Java_Spring.service.ProductService;
import com.example.Java_Spring.service.UploadService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
    
    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }


    @GetMapping(value = "/admin/product")
    public String getProductPage(Model model) {
        List<Product> products = this.productService.findAllProduct();
        model.addAttribute("products", products);
        return "Admin/Product/Show";
    }

    @GetMapping(value = "/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "Admin/Product/Create";
    }

    @PostMapping(value = "/admin/product/create")
    public String handleCreateProduct(
        Model model,
        @ModelAttribute("newProduct") @Valid Product product,
        BindingResult newProductBindingResult,
        @RequestParam("imgProductFile") MultipartFile file
    ) 
    {
        List<FieldError> errors = newProductBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>> " + error.getField() + " - " + error.getDefaultMessage());
        }
        if (newProductBindingResult.hasErrors()) {
            return "Admin/Product/Create";
        }
        String fileName = uploadService.handleSaveUploadFile(file, "product");
        product.setImage(fileName);
        this.productService.handleSaveProduct(product);
        return "redirect:/admin/product";
    }

    @GetMapping(value = "/admin/product/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable("id") long id) {
        System.out.println(">>> ID: " + id);
        model.addAttribute("product", new Product());
        model.addAttribute("id", id);
        return "Admin/Product/Delete";
    }

    @PostMapping(value = "/admin/product/delete")
    public String handleDeleteProduct(Model model, @ModelAttribute("product") Product product) {
        this.productService.deleteProductById(product.getId());
        return "redirect:/admin/product";
    }

    @GetMapping(value = "/admin/product/{id}")
    public String getDetailProductPage(Model model, @PathVariable("id") long id) {
        Product product = this.productService.findProductById(id);
        model.addAttribute("id", id);
        model.addAttribute("product", product);
        return "Admin/Product/Detail";
    }

    @GetMapping(value = "/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable("id") long id) {
        Product product = this.productService.findProductById(id);
        model.addAttribute("product", product);
        return "Admin/Product/Update";
    }

    @PostMapping(value = "/admin/product/update")
    public String hanleUpdateProduct(
        Model model, 
        @RequestParam("imgProductFile") MultipartFile file,
        @Valid @ModelAttribute("product") Product product,
        BindingResult updateProductBindingResult
    )
    {
        List<FieldError> errors = updateProductBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>> " + error.getField() + " - " + error.getDefaultMessage());
        }
        if (updateProductBindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "Admin/Product/Update";
        }
        String finalNameFile = this.uploadService.handleSaveUploadFile(file, "product"); 
        Product currentProduct = this.productService.findProductById(product.getId());
        currentProduct.setName(product.getName());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setDetailDesc(product.getDetailDesc());
        currentProduct.setShortDesc(product.getShortDesc());
        currentProduct.setQuantity(product.getQuantity());
        currentProduct.setFactory(product.getFactory());
        currentProduct.setTarget(product.getTarget());
        if (!finalNameFile.equals(""))
            currentProduct.setImage(finalNameFile);
        this.productService.handleSaveProduct(currentProduct);
        return "redirect:/admin/product";
    }
}
