package com.afs.parkinglot;

import java.util.List;

public class SuperParkingBoy {
    private List<ParkingLot> parkingLots;

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parking(Car car) {
        ParkingLot selectedParkingLot = null;
        double maxAvailableRate = -1.0;
        for (ParkingLot parkingLot : parkingLots) {
            int availablePosition = parkingLot.getAvailablePosition();
            int totalCapacity = parkingLot.getTotalCapacity();
            double availableRate = (double) availablePosition / totalCapacity;
            if (availableRate > maxAvailableRate) {
                maxAvailableRate = availableRate;
                selectedParkingLot = parkingLot;
            }
        }
        if (selectedParkingLot == null || maxAvailableRate <= 0) {
            throw new RuntimeException("No available position.");
        }
        return selectedParkingLot.parkingWithLot(car, selectedParkingLot);
    }
}
