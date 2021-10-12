package com.trips.commands;

import com.trips.service.ConsoleReaderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.trips.service.TherapyService;
import org.springframework.stereotype.Component;
import com.trips.entity.Therapy;
import com.trips.service.TicketService;

import java.util.List;
import java.util.Scanner;

@Component
@AllArgsConstructor
@Slf4j
public class TherapyPicker {

    private final TicketService ticketService;
    private final TherapyService therapyService;
    private final ConsoleReaderService consoleReaderService;

    public boolean pickTherapy() {
        List<Therapy> available = therapyService.retrieveAvailableTherapies();
        System.out.println("Available therapies: ");
        available.forEach(excursion -> System.out.print(available.indexOf(excursion)+1 + "." + excursion.toString()));
        System.out.println("If you are interested in any of these therapy trips, type its number to form a ticket.\nOtherwise type 'back'");
        String choice = consoleReaderService.getLine();
        return PickerUtils.printTrip(choice, ticketService, available);
    }
}
