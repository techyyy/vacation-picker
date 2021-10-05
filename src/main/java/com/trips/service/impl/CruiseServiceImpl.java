package com.trips.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import com.trips.service.CruiseService;
import org.springframework.stereotype.Service;
import com.trips.entity.Cruise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CruiseServiceImpl implements CruiseService {

    private static final ObjectMapper mapper = new ObjectMapper();

    public List<Cruise> retrieveAvailableCruises() {
        List<Cruise> cruises = new ArrayList<>();
        try {
            Files.walk(Paths.get("trips/cruises/"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .forEach(file -> {
                        try {
                            cruises.add(mapper.readValue(file, Cruise.class));
                        } catch (IOException e) {
                            log.error("Cannot read from file. " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            log.error("Cannot find the specified folder" + e.getMessage());
        }
        return cruises;
    }

}
