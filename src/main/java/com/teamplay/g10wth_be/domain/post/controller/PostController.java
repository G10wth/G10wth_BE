package com.teamplay.g10wth_be.domain.post.controller;

import com.teamplay.g10wth_be.domain.post.dto.PostCreateRequest;
import com.teamplay.g10wth_be.domain.post.dto.PostResponse;
import com.teamplay.g10wth_be.domain.post.dto.PostUpdateRequest;
import com.teamplay.g10wth_be.domain.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;


    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody PostCreateRequest dto) {
        return ResponseEntity.ok(service.create(dto));
    }


    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findOne(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @Valid @RequestBody PostUpdateRequest dto) {
        service.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
