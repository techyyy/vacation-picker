package com.trips.commands;

import com.trips.entity.Excursion;
import com.trips.service.ExcursionService;
import com.trips.service.PickerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class ExcursionPicker {

    private final PickerService pickerService;
    private final ExcursionService excursionService;

    public boolean pickExcursion() {
        List<Excursion> available = excursionService.retrieveAvailableExcursions();
        System.out.println("Available excursions: ");
        return pickerService.chooseTrip(available);
    }
}
