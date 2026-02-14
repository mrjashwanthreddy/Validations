package com.validations.service;

import com.validations.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void registerUser(UserDTO userDTO) {
        // 1. Simulate a Database Check
        if ("taken@example.com".equals(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }

        // 2. Simulate Business Logic (e.g., saving to DB)
        System.out.println("Saving user to database: " + userDTO.getEmail());
    }
}
