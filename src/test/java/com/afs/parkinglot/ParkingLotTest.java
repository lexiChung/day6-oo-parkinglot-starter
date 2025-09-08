package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingLotTest {
    @Test
    void should_return_ticket_when_parking_given_lot_and_car(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.parking(car);
        assertNotNull(ticket);
    }


}
