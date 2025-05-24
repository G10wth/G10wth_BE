package com.teamplay.g10wth_be.domain.post.service;

import com.teamplay.g10wth_be.domain.post.dto.PostCreateRequest;
import com.teamplay.g10wth_be.domain.post.dto.PostResponse;
import com.teamplay.g10wth_be.domain.post.dto.PostUpdateRequest;
import com.teamplay.g10wth_be.domain.post.entity.Post;
import com.teamplay.g10wth_be.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repo;

    public Long create(PostCreateRequest dto) {
        Post saved = repo.save(Post.builder()
                .title(dto.title())
                .content(dto.content())
                .image_urls(dto.imageUrls())
                .build());
        return saved.getId();
    }

    public List<PostResponse> findAll() {
        return repo.findAll().stream()
                .map(p -> new PostResponse(
                        p.getId(), p.getTitle(),
                        p.getContent(), p.getImage_urls()))
                .toList();
    }

    public PostResponse findOne(Long id) {
        Post p = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        return new PostResponse(
                p.getId(), p.getTitle(), p.getContent(), p.getImage_urls());
    }

    public void update(Long id, PostUpdateRequest dto) {
        Post p = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("글이 존재하지 않습니다."));

        p.update(dto);
    }

    public void delete(Long id) {
        Post p = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("글이 존재하지 않습니다."));
        repo.delete(p);
    }

    public Long like(Long id) {}
}
