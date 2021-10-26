package com.trips.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Slf4j
public class TicketService {
    public<T> boolean printTicket(T trip) {
        File ticket = new File("tickets/ticket" + System.currentTimeMillis() + ".txt");
        try (FileWriter myWriter = new FileWriter("tickets/ticket" + System.currentTimeMillis() + ".txt")) {
            myWriter.write(trip.toString());
        } catch (IOException e) {
            log.error("Could not create the file" + e.getMessage());
        }
        System.out.println("Purchase successful!");
        return true;
    }
}
