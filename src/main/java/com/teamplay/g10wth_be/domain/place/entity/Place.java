package com.teamplay.g10wth_be.domain.place.entity;

import com.teamplay.g10wth_be.domain.member.entity.Member;
import com.teamplay.g10wth_be.domain.place.dto.PlaceUpdateRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "places")
public class Place {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String address;

    private Double lat;
    private Double lng;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Member createdBy;

    @CreationTimestamp @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void update(PlaceUpdateRequest dto) {
        this.name = dto.name();
        this.category = dto.category();
        this.address = dto.address();
        this.lat = dto.lat();
        this.lng = dto.lng();
    }
}