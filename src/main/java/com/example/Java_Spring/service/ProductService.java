package com.example.Java_Spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Java_Spring.domain.Product;
import com.example.Java_Spring.repository.ProductRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product handleSaveProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> findAllProduct() {
        return this.productRepository.findAll();
    }

}
