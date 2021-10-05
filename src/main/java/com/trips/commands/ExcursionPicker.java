package com.trips.commands;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.trips.service.ExcursionService;
import org.springframework.stereotype.Component;
import com.trips.entity.Excursion;
import com.trips.service.TicketService;

import java.util.List;
import java.util.Scanner;

@Component
@AllArgsConstructor
@Slf4j
public class ExcursionPicker {

    private final TicketService ticketService;
    private final ExcursionService excursionService;

    public void pickExcursion(Scanner scanner) {
        List<Excursion> available = excursionService.retrieveAvailableExcursions();
        System.out.println("Available excursions: ");
        available.forEach(excursion -> System.out.print(available.indexOf(excursion)+1 + "." + excursion.toString()));
        System.out.println("If you are interested in any of these excursions, type its number to form a ticket.\nOtherwise type 'back'");
        String choice = scanner.nextLine();
        try {
            int excursionNumber = Integer.parseInt(choice);
            if(excursionNumber > 0) {
                ticketService.printTicket(available.get(excursionNumber-1));
            }
        } catch (NumberFormatException e) {
            log.info("Going back.");
        }
    }
}
