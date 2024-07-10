package com.example.Java_Spring.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String handleHello() {
        return "Hello from Service";
    }
}
