package com.teamplay.g10wth_be.domain.post.dto;

public record PostLikeUpRequest (
        Long postId,
        Long likeUserId
) {
}
