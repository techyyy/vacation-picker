package java.entity;

import java.time.LocalDate;
import java.util.List;

public class Therapy extends Trip {
    private final String recreationCenterName;
    private final String purpose;
    private final List<String> procedures;

    public Therapy(String destination, Food nutritionType, Transport transport,
                   double price, LocalDate startDate, LocalDate endDate,
                   String recreationCenterName, String purpose, List<String> procedures) {
        super(destination, nutritionType, transport, price, startDate, endDate);
        this.recreationCenterName = recreationCenterName;
        this.purpose = purpose;
        this.procedures = procedures;
    }
}
