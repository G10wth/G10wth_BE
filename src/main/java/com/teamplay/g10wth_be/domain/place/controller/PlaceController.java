package com.teamplay.g10wth_be.domain.place.controller;

import com.teamplay.g10wth_be.domain.place.dto.PlaceCreateRequest;
import com.teamplay.g10wth_be.domain.place.dto.PlaceResponse;
import com.teamplay.g10wth_be.domain.place.dto.PlaceUpdateRequest;
import com.teamplay.g10wth_be.domain.place.service.PlaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService service;


    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody PlaceCreateRequest dto) {
        return ResponseEntity.ok(service.create(dto));
    }


    @GetMapping
    public ResponseEntity<List<PlaceResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceResponse> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findOne(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @Valid @RequestBody PlaceUpdateRequest dto) {
        service.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}