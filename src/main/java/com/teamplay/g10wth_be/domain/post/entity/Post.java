package com.teamplay.g10wth_be.domain.post.entity;

import com.teamplay.g10wth_be.domain.member.entity.Member;
import com.teamplay.g10wth_be.domain.post.dto.PostUpdateRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String image_urls;

    private Double likes;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void update(PostUpdateRequest dto) {
        dto.title();
        dto.content();
        dto.imageUrls();
    }
}
