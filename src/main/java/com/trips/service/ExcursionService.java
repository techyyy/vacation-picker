package com.trips.service;

import com.trips.entity.Excursion;

import java.util.List;

public interface ExcursionService {
    List<Excursion> retrieveAvailableExcursions();
}
