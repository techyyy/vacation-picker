package com.trips.service;

import com.trips.entity.Cruise;

import java.util.List;

public interface CruiseService {
    List<Cruise> retrieveAvailableCruises();
}
