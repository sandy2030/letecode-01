package com.parkinglot;

import java.util.Date;

class Ticket {
     Vehicle vehicle;
     Date entryTime;
     Date exitTime;
     double fee;
    public Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.entryTime = new Date();
    }

    public void exit() {
        this.exitTime = new Date();
    }

    public void calculateFee() {
        long duration = (exitTime.getTime() - entryTime.getTime()) / 1000; // Duration in seconds
        fee = FeeCalculator.calculateFee(duration, vehicle.getType());
    }

    public double getFee() {
        return fee;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }
}