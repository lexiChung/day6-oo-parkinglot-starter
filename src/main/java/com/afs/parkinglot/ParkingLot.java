package com.afs.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Map<Ticket,Car> ticketCarMap = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket parking(Car car) {
        if(capacity<=0) throw new RuntimeException("No available position.");
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket,car);
        capacity--;
        return ticket;
    }
}
