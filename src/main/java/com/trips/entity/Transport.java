package com.trips.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Setter
public class Transport {
    private TransportType transportType;
    private double price;

    public Transport(TransportType transportType, double price) {
        this.transportType = transportType;
        this.price = price;
    }
}