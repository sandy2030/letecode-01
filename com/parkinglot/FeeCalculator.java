package com.parkinglot;

class FeeCalculator {
    public static double calculateFee(long duration, VehicleType type) {
        double ratePerHour;
        switch (type){
            case CAR: ratePerHour=10;break;
            case BIKE: ratePerHour=5;break;
            case TRUCK: ratePerHour=20;break;
            default:ratePerHour=0;
        }
        return (duration / 3600.0) * ratePerHour; // Calculate based on hours
    }
}