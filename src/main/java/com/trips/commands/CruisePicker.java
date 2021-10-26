package com.trips.commands;

import com.trips.entity.Cruise;
import com.trips.service.CruiseService;
import com.trips.service.PickerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class CruisePicker {

    private final PickerService pickerService;
    private final CruiseService cruiseService;

    public boolean pickCruise() {
        List<Cruise> available = cruiseService.retrieveAvailableCruises();
        System.out.println("Available cruises: ");
        return pickerService.chooseTrip(available);
    }
}
