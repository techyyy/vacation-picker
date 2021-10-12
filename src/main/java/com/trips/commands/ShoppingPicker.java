package com.trips.commands;

import com.trips.service.ConsoleReaderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.trips.service.ShoppingService;
import org.springframework.stereotype.Component;
import com.trips.entity.Shopping;
import com.trips.service.TicketService;

import java.util.List;
import java.util.Scanner;

@Component
@AllArgsConstructor
@Slf4j
public class ShoppingPicker {

    private final TicketService ticketService;
    private final ShoppingService shoppingService;
    private final ConsoleReaderService consoleReaderService;

    public boolean pickShopping() {
        List<Shopping> available = shoppingService.retrieveAvailableShoppings();
        System.out.println("Available shopping trips: ");
        available.forEach(excursion -> System.out.print(available.indexOf(excursion)+1 + "." + excursion.toString()));
        System.out.println("If you are interested in any of these shopping trips, type its number to form a ticket.\nOtherwise type 'back'");
        String choice = consoleReaderService.getLine();
        return PickerUtils.printTrip(choice, ticketService, available);
    }
}
