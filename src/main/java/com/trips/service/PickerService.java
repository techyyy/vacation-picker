package com.trips.service;

import com.trips.commands.PickerUtils;
import com.trips.entity.Trip;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.trips.commands.PickerUtils.printTrips;

@Service
@AllArgsConstructor
public class PickerService {

    private final TicketService ticketService;
    private final ConsoleReaderService consoleReaderService;

    public boolean chooseTrip(List<? extends Trip> available) {
        printTrips(available);
        while (true) {
            System.out.println("If you are interested in any of these cruises, type 'buy {number of cruise}' to form a ticket." +
                    "To sort tickets by price type 'sort'" +
                    "\nOtherwise type 'back'");
            String choice = consoleReaderService.getLine();
            if(choice.startsWith("buy")) {
                try {
                    String[] input = choice.split("\s");
                    return PickerUtils.printTrip(input[1], ticketService, available);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("There's no such cruise.");
                }
            }
            if(choice.startsWith("sort")) {
                Collections.sort(available);
                printTrips(available);
            }
            if(choice.startsWith("back")) {
                break;
            }
        }
        return false;
    }
}
