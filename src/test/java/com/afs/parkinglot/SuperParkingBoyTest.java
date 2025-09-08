package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperParkingBoyTest {
    @Test
    void should_park_in_parking_lot2_when_parking_lot2_has_higher_available_rate() {
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(20);
        parkingLot1.parking(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(java.util.Arrays.asList(parkingLot1, parkingLot2));
        Car car = new Car();
        Ticket ticket = superParkingBoy.parking(car);
        assertEquals(parkingLot2, ticket.getParkingLot());
    }
}
