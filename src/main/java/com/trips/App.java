package com.trips;

import com.trips.commands.*;
import com.trips.service.ConsoleReaderService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;


import java.util.Scanner;

@SpringBootApplication
@AllArgsConstructor
public class App implements CommandLineRunner {

    @Lazy
    private final CruisePicker cruisePicker;

    @Lazy
    private final ExcursionPicker excursionPicker;

    @Lazy
    private final RecreationPicker recreationPicker;

    @Lazy
    private final ShoppingPicker shoppingPicker;

    @Lazy
    private final TherapyPicker therapyPicker;

    private final ConsoleReaderService consoleReaderService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        while (true) {
            System.out.println("Trip management");
            System.out.println("Cruise     --- 1");
            System.out.println("Excursion  --- 2");
            System.out.println("Therapy    --- 3");
            System.out.println("Recreation --- 4");
            System.out.println("Shopping   --- 5");
            System.out.println("Stop       --- 0");

            String choice = consoleReaderService.getLine();

            switch (choice) {
                case "1":
                    cruisePicker.pickCruise();
                    break;
                case "2":
                    excursionPicker.pickExcursion();
                    break;
                case "3":
                    therapyPicker.pickTherapy();
                    break;
                case "4":
                    recreationPicker.pickRecreation();
                    break;
                case "5":
                    shoppingPicker.pickShopping();
                    break;
                case "0":
                    return;
                default:
                    break;
            }
        }
    }
}
