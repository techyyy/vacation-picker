package com.trips.commands;

import com.trips.entity.Therapy;
import com.trips.service.PickerService;
import com.trips.service.TherapyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class TherapyPicker {

    private final PickerService pickerService;
    private final TherapyService therapyService;

    public boolean pickTherapy() {
        List<Therapy> available = therapyService.retrieveAvailableTherapies();
        System.out.println("Available therapies: ");
        return pickerService.chooseTrip(available);
    }
}
