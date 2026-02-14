package com.validations.annotation;

import com.validations.dto.UserDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MaritalStatusValidator implements ConstraintValidator<ValidMaritalStatus, UserDTO> {
    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext context) {
        // 1. If user is NOT married, validation passes automatically
        if (Boolean.FALSE.equals(userDTO.getMarried())) { // Handle null safety
            return true;
        }

        // 2. If user IS married, check if partnerName is present
        return userDTO.getPartnerName() != null && !userDTO.getPartnerName().isBlank();
    }
}
