package task.entity;

import java.time.LocalDate;

public class Recreation extends Trip {
    private final String resortName;
    private final RecreationType recreationType;

    public Recreation(String destination, Food nutritionType,
                      Transport transport, double price,
                      LocalDate startDate, LocalDate endDate,
                      String resortName, RecreationType recreationType) {
        super(destination, nutritionType, transport, price, startDate, endDate);
        this.resortName = resortName;
        this.recreationType = recreationType;
    }
}
