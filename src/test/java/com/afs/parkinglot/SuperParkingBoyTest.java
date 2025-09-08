package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void should_fetch_right_car_when_fetching_given_multiple_parking_lots() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(20);
        parkingLot1.parking(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(List.of(parkingLot1, parkingLot2));
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = superParkingBoy.parking(car1);
        Ticket ticket2 = superParkingBoy.parking(car2);
        assertEquals(car1, superParkingBoy.fetching(ticket1));
        assertEquals(car2, superParkingBoy.fetching(ticket2));
    }
}
