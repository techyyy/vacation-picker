package com.trips.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Shopping extends Trip {
    private List<String> cityNames;

    public Shopping(String destination, Food nutritionType, Transport transport,
                    double price, LocalDate startDate, LocalDate endDate,
                    List<String> cityNames) {
        super(destination, nutritionType, transport, price, startDate, endDate);
        this.cityNames = new ArrayList<>();
        this.cityNames.add(destination);
        this.cityNames.addAll(cityNames);
    }

    @Override
    public String toString() {
        return super.toString()+
                "\n cityNames=" + cityNames +
                '\n';
    }
}
