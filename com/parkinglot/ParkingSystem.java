package com.parkinglot;

public class ParkingSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5, 5, 2);

        // Vehicle enters
        Vehicle car = new Vehicle("ABC123", VehicleType.CAR);
        Ticket ticket = parkingLot.parkVehicle(car);

        // Simulate exit after some time
        try {
            Thread.sleep(5000); // 5 seconds parking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parkingLot.vacateSlot(ticket);
    }
}