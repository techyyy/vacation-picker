package com.trips.service;

import com.trips.entity.Recreation;

import java.util.List;

public interface RecreationService {
    List<Recreation> retrieveAvailableRecreations();
}
