package com.trips.commands;

import com.trips.entity.Recreation;
import com.trips.service.PickerService;
import com.trips.service.RecreationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class RecreationPicker {

    private final PickerService pickerService;
    private final RecreationService recreationService;

    public boolean pickRecreation() {
        List<Recreation> available = recreationService.retrieveAvailableRecreations();
        System.out.println("Available recreations: ");
        return pickerService.chooseTrip(available);
    }
}
