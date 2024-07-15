package com.example.Java_Spring.service;

import java.util.List;

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

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User getUserByEmailOrAddress(String email, String address) {
        return this.userRepository.findFirstByEmailOrAddress(email, address);
    }
}
