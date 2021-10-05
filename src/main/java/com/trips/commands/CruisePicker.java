package com.trips.commands;

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

    public void pickCruise(Scanner scanner) {
        List<Cruise> available = cruiseService.retrieveAvailableCruises();
        System.out.println("Available cruises: ");
        available.forEach(cruise -> System.out.print(available.indexOf(cruise)+1 + "." + cruise.toString()));
        System.out.println("If you are interested in any of these cruises, type its number to form a ticket.\nOtherwise type 'back'");
        String choice = scanner.nextLine();
        try {
            int cruiseNumber = Integer.parseInt(choice);
            if(cruiseNumber > 0) {
                ticketService.printTicket(available.get(cruiseNumber-1));
            }
        } catch (NumberFormatException e) {
            log.info("Going back.");
        }
    }
}
