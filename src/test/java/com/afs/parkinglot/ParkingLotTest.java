package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void should_return_ticket_when_parking_given_lot_and_car(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.parking(car);
        assertNotNull(ticket);
    }

    @Test
    void should_throw_exception_when_parking_given_full_lot_and_car(){
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car();
        parkingLot.parking(car1);
        Car car2 = new Car();
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            parkingLot.parking(car2);});
        assertEquals("No available position.", exception.getMessage());
    }

    @Test
    void should_return_car_when_fetching_given_lot_and_ticket(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.parking(car);
        Car fetchedCar = parkingLot.fetching(ticket);
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_throw_exception_when_fetching_given_lot_and_invalid_ticket(){
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket invalidTicket = new Ticket();
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            parkingLot.fetching(invalidTicket);});
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
}
