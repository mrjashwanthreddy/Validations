package com.validations.dto;

import com.validations.annotation.ValidMaritalStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@ValidMaritalStatus // <--- Applying the custom validation here!
public class UserDTO {
    @NotBlank(message = "Username is Required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters.")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than 100")
    private Integer age;

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth cannot be in the future")
    private LocalDate dateOfBirth;

    private Boolean married;
    private String partnerName;

    // --- TRANSFORMATION LOGIC ---

    // 1. Trim whitespace from Username
    public void setUsername(String username) {
        if (username != null) {
            this.username = username.trim();
        }
    }

    // 2. Normalize Email to Lowercase & Trim
    public void setEmail(String email) {
        if (email != null) {
            this.email = email.trim().toLowerCase();
        }
    }
}
