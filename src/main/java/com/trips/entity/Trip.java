package com.trips.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Trip implements Comparable<Trip>{
    private String destination;
    private Food nutritionType;
    private Transport transport;
    private double price;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate;

    protected Trip(String destination, Food nutritionType,
                Transport transport, double price, LocalDate startDate,
                LocalDate endDate) {
        this.destination = destination;
        this.nutritionType = nutritionType;
        this.transport = transport;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return " Trip ----------------------" +
                "\n destination='" + destination +
                "\n nutritionType=" + nutritionType +
                "\n transport=" + transport +
                "\n price=" + price +
                "\n startDate=" + startDate +
                "\n endDate=" + endDate;
    }

    @Override
    public int compareTo(Trip o) {
        return price > o.price ? 1 : -1;
    }
}
