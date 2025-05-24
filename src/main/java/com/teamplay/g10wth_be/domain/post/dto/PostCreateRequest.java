package com.teamplay.g10wth_be.domain.post.dto;

import jakarta.validation.constraints.NotBlank;

public record PostCreateRequest (
        @NotBlank String title,
        @NotBlank String content,
        String imageUrls
){
}
