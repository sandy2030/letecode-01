package com.parkinglot;

class Vehicle {
    protected String numberPlate;
    protected VehicleType vehicleType;

    public Vehicle(String numberPlate, VehicleType vehicleType) {
        this.numberPlate=numberPlate;
        this.vehicleType=vehicleType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}