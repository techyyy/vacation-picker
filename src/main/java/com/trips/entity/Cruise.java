package com.trips.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Cruise extends Trip {
    private String shipName;
    private List<String> checkpoints;

    public Cruise( String destination, Food nutritionType,
                   Transport transport, double price,LocalDate startDate,
                  LocalDate endDate, String shipName,List<String> checkpoints) {
        super(destination, nutritionType, transport, price, startDate, endDate);
        this.shipName = shipName;
        this.checkpoints = checkpoints;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n shipName='" + shipName + '\'' +
                "\n checkpoints=" + checkpoints +
                '\n' + '\n';
    }
}
