package com.teamplay.g10wth_be.domain.member.dto;

import jakarta.validation.constraints.*;

public record SignupRequest(
        @Email @NotBlank String email,
        @Size(min = 8) String password,
        @NotBlank String nickname
) {}