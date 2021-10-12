package com.trips.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleReaderService {

    private final Scanner scanner = new Scanner(System.in);

    public String getLine() {
        return scanner.nextLine();
    }
}
