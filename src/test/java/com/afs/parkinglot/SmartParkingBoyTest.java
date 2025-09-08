package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_park_in_parking_lot_2_when_parking_lot_2_has_more_available_position() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLot1, parkingLot2));
        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.parking(car);
        assertEquals(parkingLot2, ticket.getParkingLot());
    }

    @Test
    void should_park_in_parking_lot_1_when_parking_lots_has_same_available_position() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLot1, parkingLot2));
        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.parking(car);
        assertEquals(parkingLot1, ticket.getParkingLot());
    }

}
