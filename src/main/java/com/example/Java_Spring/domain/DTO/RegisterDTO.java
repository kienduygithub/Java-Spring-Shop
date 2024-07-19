package com.example.Java_Spring.domain.DTO;

import com.example.Java_Spring.service.validator.EmailChecked;
import com.example.Java_Spring.service.validator.RegisterChecked;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@RegisterChecked
public class RegisterDTO {

    @Size(min = 3, message = "FirstName phải có tối thiểu 3 ký tự")
    private String firstName;
    private String lastName;

    @EmailChecked
    private String email;
    
    private String password;
    private String confirmPassword;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    
}
