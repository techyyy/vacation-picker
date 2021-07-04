package java.entity;

import java.time.LocalDate;
import java.util.List;

public class Excursion extends Trip {
    private List<String> placesToVisit;
    private final String commodityName;
    private final String guideName;

    public Excursion(String destination, Food nutritionType, Transport transport,
                     double price, LocalDate startDate, LocalDate endDate,
                     String commodityName, String guideName) {
        super(destination, nutritionType, transport, price, startDate, endDate);
        this.commodityName = commodityName;
        this.guideName = guideName;
    }
}
