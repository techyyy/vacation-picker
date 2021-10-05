package com.trips.commands;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.trips.service.RecreationService;
import org.springframework.stereotype.Component;
import com.trips.entity.Recreation;
import com.trips.service.TicketService;

import java.util.List;
import java.util.Scanner;

@Component
@AllArgsConstructor
@Slf4j
public class RecreationPicker {

    private final TicketService ticketService;
    private final RecreationService recreationService;

    public void pickRecreation(Scanner scanner) {
        List<Recreation> available = recreationService.retrieveAvailableRecreations();
        System.out.println("Available recreations: ");
        available.forEach(recreation -> System.out.print(available.indexOf(recreation)+1 + "." + recreation.toString()));
        System.out.println("If you are interested in any of these recreations, type its number to form a ticket.\nOtherwise type 'back'");
        String choice = scanner.nextLine();
        try {
            int recreationNumber = Integer.parseInt(choice);
            if(recreationNumber > 0) {
                ticketService.printTicket(available.get(recreationNumber));
            }
        } catch (NumberFormatException e) {
            log.info("Going back.");
        }
    }
}
