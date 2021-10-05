package com.trips.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Excursion extends Trip {
    private List<String> placesToVisit;
    private String commodityName;
    private String guideName;

    public Excursion(String destination, Food nutritionType, Transport transport,
                     double price, LocalDate startDate, LocalDate endDate,
                     String commodityName, String guideName) {
        super(destination, nutritionType, transport, price, startDate, endDate);
        this.commodityName = commodityName;
        this.guideName = guideName;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nplacesToVisit=" + placesToVisit +
                "\n commodityName='" + commodityName + '\'' +
                "\n guideName='" + guideName +
                '\n';
    }
}
