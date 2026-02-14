package com.validations.controller;

import com.validations.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    // The @Valid annotation triggers the validation logic BEFORE the method runs
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO userDTO) {
        System.out.println(" Received User: " + userDTO.toString());
        return ResponseEntity.ok("User registered successfully!");
    }
}
