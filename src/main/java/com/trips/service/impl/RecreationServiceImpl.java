package com.trips.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.trips.entity.Recreation;
import com.trips.service.RecreationService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RecreationServiceImpl implements RecreationService {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Recreation> retrieveAvailableRecreations() {
        List<Recreation> recreations = new ArrayList<>();
        try {
            Files.walk(Paths.get("trips/recreations/"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .forEach(file -> {
                        try {
                            recreations.add(mapper.readValue(file, Recreation.class));
                        } catch (IOException e) {
                            log.error("Cannot read from file. " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            log.error("Cannot find the specified folder" + e.getMessage());
        }
        return recreations;
    }
}
