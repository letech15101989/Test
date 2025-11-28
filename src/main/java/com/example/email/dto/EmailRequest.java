package com.example.email.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailRequest(
        @Email @NotBlank String to,
        @NotBlank String message,
        String subject,
        String contactName,
        @Email String contactEmail,
        String contactPhone,
        String company
) {
}

