package task.entity;

public class Transport {
    private final TransportType transportType;
    private final double price;

    public Transport(TransportType transportType, double price) {
        this.transportType = transportType;
        this.price = price;
    }
}