package com.afs.parkinglot;

public class StandardParkingBoy {
    private ParkingLot parkingLot;

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parking(Car car) {
        return parkingLot.parking(car);
    }

    public Car fetching(Ticket ticket) {
        return parkingLot.fetching(ticket);
    }

}
