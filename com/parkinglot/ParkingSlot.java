package com.parkinglot;

class ParkingSlot {
    private VehicleType type;
    private boolean isOccupied;

    public ParkingSlot(VehicleType type) {
        this.type = type;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void park() {
        this.isOccupied = true;
    }

    public void vacate() {
        this.isOccupied = false;
    }

    public VehicleType getType() {
        return type;
    }
}
