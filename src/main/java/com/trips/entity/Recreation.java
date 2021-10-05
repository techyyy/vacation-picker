package com.trips.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Recreation extends Trip {
    private String resortName;
    private RecreationType recreationType;

    public Recreation(String destination, Food nutritionType,
                      Transport transport, double price,
                      LocalDate startDate, LocalDate endDate,
                      String resortName, RecreationType recreationType) {
        super(destination, nutritionType, transport, price, startDate, endDate);
        this.resortName = resortName;
        this.recreationType = recreationType;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\n resortName='" + resortName + '\'' +
                "\n recreationType=" + recreationType +
                '\n' + '\n';
    }
}
