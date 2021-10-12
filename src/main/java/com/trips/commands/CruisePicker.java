package com.trips.commands;

import com.trips.service.ConsoleReaderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.trips.entity.Cruise;
import com.trips.service.CruiseService;
import com.trips.service.TicketService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@AllArgsConstructor
@Slf4j
public class CruisePicker {

    private final TicketService ticketService;
    private final CruiseService cruiseService;
    private final ConsoleReaderService consoleReaderService;

    public boolean pickCruise() {
        List<Cruise> available = cruiseService.retrieveAvailableCruises();
        System.out.println("Available cruises: ");
        available.forEach(cruise -> System.out.print(available.indexOf(cruise)+1 + "." + cruise.toString()));
        System.out.println("If you are interested in any of these cruises, type its number to form a ticket.\nOtherwise type 'back'");
        String choice = consoleReaderService.getLine();
        return PickerUtils.printTrip(choice, ticketService, available);
    }
}
