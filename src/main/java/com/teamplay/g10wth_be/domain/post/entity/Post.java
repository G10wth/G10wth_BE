package com.teamplay.g10wth_be.domain.post.entity;

import com.teamplay.g10wth_be.domain.member.entity.Member; // 엔티티 구조 파악 및 커밋

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Table(name = "post")
public class Post {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id") // 명확한 테이블 구분을 위한 임의의 이름 추가
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Column(nullable = false)
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
