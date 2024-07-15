package com.example.Java_Spring.service;

import org.springframework.stereotype.Service;

import com.example.Java_Spring.domain.User;
import com.example.Java_Spring.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleSaveUser(User user) {
        User createdUser = this.userRepository.save(user);
        System.out.println(createdUser);
        return createdUser;
    }
}
