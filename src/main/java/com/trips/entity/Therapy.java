package com.trips.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Therapy extends Trip {
    private String recreationCenterName;
    private String purpose;
    private List<String> procedures;

    public Therapy(String destination, Food nutritionType, Transport transport,
                   double price, LocalDate startDate, LocalDate endDate,
                   String recreationCenterName, String purpose, List<String> procedures) {
        super(destination, nutritionType, transport, price, startDate, endDate);
        this.recreationCenterName = recreationCenterName;
        this.purpose = purpose;
        this.procedures = procedures;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nrecreationCenterName='" + recreationCenterName + '\'' +
                "\n purpose='" + purpose + '\'' +
                "\n procedures=" + procedures +
                '\n';
    }
}
