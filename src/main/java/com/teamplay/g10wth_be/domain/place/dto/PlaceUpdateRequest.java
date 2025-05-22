package com.teamplay.g10wth_be.domain.place.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlaceUpdateRequest(
        @NotBlank String name,
        @NotBlank String category,
        @NotBlank String address,
        @NotNull  Double lat,
        @NotNull  Double lng
) {}