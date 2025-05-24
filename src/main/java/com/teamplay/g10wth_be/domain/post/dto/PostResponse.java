package com.teamplay.g10wth_be.domain.post.dto;

public record PostResponse(
        Long id,
        String title,
        String content,
        String imageUrls
) {

}
