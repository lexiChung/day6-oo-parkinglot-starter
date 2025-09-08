package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardParkingBoyTest {
    @Test
    void should_return_ticket_when_parking_given_parking_boy_and_car(){
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.parking(car);
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetching_given_parking_boy_and_ticket(){
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.parking(car);
        Car fetchedCar = parkingBoy.fetching(ticket);
        assertEquals(car, fetchedCar);
    }
}

