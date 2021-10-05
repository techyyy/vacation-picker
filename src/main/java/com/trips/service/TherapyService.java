package com.trips.service;

import com.trips.entity.Therapy;

import java.util.List;

public interface TherapyService {
    List<Therapy> retrieveAvailableTherapies();
}
