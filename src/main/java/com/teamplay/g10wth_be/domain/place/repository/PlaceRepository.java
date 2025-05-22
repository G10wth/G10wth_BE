package com.teamplay.g10wth_be.domain.place.repository;

import com.teamplay.g10wth_be.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {}