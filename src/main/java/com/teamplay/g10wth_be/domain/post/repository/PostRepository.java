package com.teamplay.g10wth_be.domain.post.repository;

import com.teamplay.g10wth_be.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
