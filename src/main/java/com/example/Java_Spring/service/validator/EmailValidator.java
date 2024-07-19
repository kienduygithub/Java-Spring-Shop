package com.example.Java_Spring.service.validator;

import org.springframework.stereotype.Service;

import com.example.Java_Spring.service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Service
public class EmailValidator implements ConstraintValidator<EmailChecked, String> {

    private final UserService userService;

    public EmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid = true;
        if (value.isEmpty()) {
            context.buildConstraintViolationWithTemplate("Email không được bỏ trống")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        } else {
            if (!value.matches("^[A-Za-z0-9_-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                context.buildConstraintViolationWithTemplate("Email không hợp lệ")
                        .addConstraintViolation()
                        .disableDefaultConstraintViolation();
                valid = false;
            } else {
                boolean isEmailExist = this.userService.checkEmailExist(value);
                if (isEmailExist == true) {
                    context.buildConstraintViolationWithTemplate("Email đã tồn tại")
                                .addConstraintViolation()
                                .disableDefaultConstraintViolation();
                    valid = false;
                }
            }
        }
        return valid;
    }
}
