package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int TotalCapacity;
    private int availableCapacity;
    private Map<Ticket,Car> ticketCarMap = new HashMap<>();

    public ParkingLot(int availableCapacity) {
        this.availableCapacity = availableCapacity;
        this.TotalCapacity = availableCapacity;
    }

    public int getTotalCapacity() {
        return TotalCapacity;
    }

    public Ticket parking(Car car) {
        if(availableCapacity <=0) throw new RuntimeException("No available position.");
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket,car);
        availableCapacity--;
        return ticket;
    }

    public Ticket parkingWithLot(Car car,ParkingLot parkingLot) {
        if(availableCapacity <=0) throw new RuntimeException("No available position.");
        Ticket ticket = new Ticket();
        ticket.setParkingLot(parkingLot);
        ticketCarMap.put(ticket,car);
        availableCapacity--;
        return ticket;
    }

    public Car fetching(Ticket ticket) {
        if(!ticketCarMap.containsKey(ticket)) throw new RuntimeException("Unrecognized parking ticket.");
        Car car = ticketCarMap.get(ticket);
        ticketCarMap.remove(ticket);
        availableCapacity++;
        return car;
    }

    public int getAvailablePosition() {
        return availableCapacity;
    }
}
