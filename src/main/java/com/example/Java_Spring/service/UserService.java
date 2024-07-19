package com.example.Java_Spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Java_Spring.domain.Role;
import com.example.Java_Spring.domain.User;
import com.example.Java_Spring.domain.DTO.RegisterDTO;
import com.example.Java_Spring.repository.RoleRepository;
import com.example.Java_Spring.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
        return this.userRepository.findOneByEmail(email);
    }

    public User getUserByEmailOrAddress(String email, String address) {
        return this.userRepository.findFirstByEmailOrAddress(email, address);
    }

    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    public Role getRoleByName(String roleName) {
        return this.roleRepository.findByName(roleName);
    }

    public User registerDTOtoUser(RegisterDTO registerDTO) {
        User user = new User();

        user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());

        return user;
    }
    
    public boolean checkEmailExist(String email) {
        return this.userRepository.existsByEmail(email);
    }

    // Dùng cho UserDetailsService của Spring Security
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
