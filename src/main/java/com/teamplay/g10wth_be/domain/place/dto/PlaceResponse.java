package com.teamplay.g10wth_be.domain.place.dto;

public record PlaceResponse(
        Long id, String name, String category,
        String address, Double lat, Double lng
) {}