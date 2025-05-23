package com.teamplay.g10wth_be.domain.place.service;

import com.teamplay.g10wth_be.domain.place.dto.PlaceCreateRequest;
import com.teamplay.g10wth_be.domain.place.dto.PlaceResponse;
import com.teamplay.g10wth_be.domain.place.dto.PlaceUpdateRequest;
import com.teamplay.g10wth_be.domain.place.entity.Place;
import com.teamplay.g10wth_be.domain.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository repo;

    @Transactional
    public Long create(PlaceCreateRequest dto) {
        Place saved = repo.save(Place.builder()
                .name(dto.name())
                .category(dto.category())
                .address(dto.address())
                .lat(dto.lat())
                .lng(dto.lng())
                .build());
        return saved.getId();
    }

    @Transactional(readOnly = true)
    public List<PlaceResponse> findAll() {
        return repo.findAll().stream()
                .map(p -> new PlaceResponse(
                        p.getId(), p.getName(), p.getCategory(),
                        p.getAddress(), p.getLat(), p.getLng()))
                .toList();
    }

    @Transactional(readOnly = true)
    public PlaceResponse findOne(Long id) {
        Place p = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Place not found"));
        return new PlaceResponse(
                p.getId(), p.getName(), p.getCategory(),
                p.getAddress(), p.getLat(), p.getLng());
    }

    @Transactional
    public void update(Long id, PlaceUpdateRequest dto) {
        Place place = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 장소입니다."));

        place.update(dto);
    }

    @Transactional
    public void delete(Long id) {
        Place place = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 장소입니다."));
        repo.delete(place);
    }
}