package com.validations.controller;

import com.validations.dto.UserDTO;
import com.validations.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    // The @Valid annotation triggers the validation logic BEFORE the method runs
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO userDTO) {
        // The @Valid check happens BEFORE this line.
        // If we get here, syntax is good. Now check business logic.

        userService.registerUser(userDTO); // This might throw IllegalArgumentException

        return ResponseEntity.ok("User registered successfully!");
    }
}
