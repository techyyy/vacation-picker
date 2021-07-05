package task.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shopping extends Trip {
    private final List<String> cityNames;

    public Shopping(String destination, Food nutritionType, Transport transport,
                    double price, LocalDate startDate, LocalDate endDate,
                    List<String> cityNames) {
        super(destination, nutritionType, transport, price, startDate, endDate);
        this.cityNames = new ArrayList<>();
        this.cityNames.add(destination);
        this.cityNames.addAll(cityNames);
    }
}
