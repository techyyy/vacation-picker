package com.trips.commands;

import com.trips.entity.Trip;
import com.trips.service.TicketService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PickerUtils {
    public static boolean printTrip(String choice, TicketService ticketService, List<? extends Trip> available) {
        try {
            int therapyNumber = Integer.parseInt(choice);
            if(therapyNumber > 0) {
                ticketService.printTicket(available.get(therapyNumber));
            }
        } catch (NumberFormatException e) {
            log.info("Going back.");
        }
        return true;
    }
}
