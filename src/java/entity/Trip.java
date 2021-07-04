package java.entity;

import java.time.LocalDate;

public class Trip {
    private final String destination;
    private final Food nutritionType;
    private final Transport transport;
    private final double price;
    private final LocalDate startDate;
    private final LocalDate endDate;

    protected Trip(String destination, Food nutritionType,
                Transport transport, double price, LocalDate startDate,
                LocalDate endDate) {
        this.destination = destination;
        this.nutritionType = nutritionType;
        this.transport = transport;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
