package task.entity;

import java.time.LocalDate;
import java.util.List;

public class Cruise extends Trip {
    private final String shipName;
    private final List<String> checkpoints;

    public Cruise(String destination, Food nutritionType,
                  Transport transport, double price, LocalDate startDate,
                  LocalDate endDate, String shipName, List<String> checkpoints) {
        super(destination, nutritionType, transport, price, startDate, endDate);
        this.shipName = shipName;
        this.checkpoints = checkpoints;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Cruise{" +
                "shipName='" + shipName + '\'' +
                ", checkpoints=" + checkpoints +
                '}';
    }
}
