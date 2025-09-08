package com.afs.parkinglot;

import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    //优先停到空位数最多的停车场，如果一样，就按顺序停。
    public Ticket parking(Car car) {
        ParkingLot selectedParkingLot = null;
        int maxAvailablePosition = -1;
        for (ParkingLot parkingLot : parkingLots) {
            int availablePosition = parkingLot.getAvailablePosition();
            if (availablePosition > maxAvailablePosition) {
                maxAvailablePosition = availablePosition;
                selectedParkingLot = parkingLot;
            }
        }
        if (selectedParkingLot == null || maxAvailablePosition <= 0) {
            throw new RuntimeException("No available position.");
        }
        return selectedParkingLot.parkingWithLot(car,selectedParkingLot);
    }

    public Car fetching(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.fetching(ticket);
            } catch (RuntimeException e) {}
        }
        throw new RuntimeException("Unrecognized parking ticket.");
    }
}
