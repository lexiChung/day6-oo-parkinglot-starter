package com.afs.parkinglot;

import java.util.HashMap;
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

    public Ticket parkingWithLot(Car car,ParkingLot parkingLot) {
        if(capacity<=0) throw new RuntimeException("No available position.");
        Ticket ticket = new Ticket();
        ticket.setParkingLot(parkingLot);
        ticketCarMap.put(ticket,car);
        capacity--;
        return ticket;
    }

    public Car fetching(Ticket ticket) {
        if(!ticketCarMap.containsKey(ticket)) throw new RuntimeException("Unrecognized parking ticket.");
        Car car = ticketCarMap.get(ticket);
        ticketCarMap.remove(ticket);
        capacity++;
        return car;
    }

    public int getAvailablePosition() {
        return capacity;
    }
}
