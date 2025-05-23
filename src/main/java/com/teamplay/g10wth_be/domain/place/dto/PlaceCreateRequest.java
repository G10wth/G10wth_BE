package com.teamplay.g10wth_be.domain.place.dto;

import jakarta.validation.constraints.*;

public record PlaceCreateRequest(
        @NotBlank  @Size(max = 50) String name,
        @NotBlank @Size(max = 30) String category,
        @NotBlank String address,
        @NotNull  @DecimalMin("-90")  @DecimalMax("90") Double lat,
        @NotNull  @DecimalMin("-180") @DecimalMax("180") Double lng
) {}