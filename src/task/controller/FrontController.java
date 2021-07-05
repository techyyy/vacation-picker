package task.controller;

import task.action.CommandMapping;

import java.util.Scanner;

public class FrontController {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Trip management");
            System.out.println("Cruise     --- 1");
            System.out.println("Excursion  --- 2");
            System.out.println("Therapy    --- 3");
            System.out.println("Recreation --- 4");
            System.out.println("Shopping   --- 5");
            System.out.println("Stop       --- 0");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            String commandName = null;

            switch (choice) {
                case "1":
                    commandName = "NewCruise";
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "0":
                    return;
                default:
                    break;
            }
            CommandMapping.get(commandName).execute(scanner);
        }
    }
}
