package com.trips.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import com.trips.service.TherapyService;
import org.springframework.stereotype.Service;
import com.trips.entity.Therapy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TherapyServiceImpl implements TherapyService {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Therapy> retrieveAvailableTherapies() {
        List<Therapy> therapies = new ArrayList<>();
        try {
            Files.walk(Paths.get("trips/therapies/"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .forEach(file -> {
                        try {
                            therapies.add(mapper.readValue(file, Therapy.class));
                        } catch (IOException e) {
                            log.error("Cannot read from file. " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            log.error("Cannot find the specified folder" + e.getMessage());
        }
        return therapies;
    }
}
