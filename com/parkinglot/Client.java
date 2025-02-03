package com.parkinglot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<ParkingSlot> slots=getSlots();
        ParkingLot parkingLot=new ParkingLot();
    }
    static List<ParkingSlot> getSlots(){
        Vehicle v1=new Vehicle("MH121694",VehicleType.BIKE);
        Vehicle v2=new Vehicle("TS454502",VehicleType.CAR);
        Vehicle v3=new Vehicle("MP204578",VehicleType.TRUCK);
        Vehicle v4=new Vehicle("DL018987",VehicleType.CAR);
        LocalDateTime et1=date("2025-01-27 10:15:30 AM");
        LocalDateTime ex1=date("2019-01-27 12:15:30 PM");
        LocalDateTime et2=date("2019-01-27 03:00:00 AM");
        LocalDateTime ex2=date("2019-01-27 07:00:00 AM");
        LocalDateTime et3=date("2019-01-27 02:00:00 PM");
        LocalDateTime ex3=date("2019-01-27 07:00:00 PM");
        LocalDateTime et4=date("2019-01-27 08:00:00 PM");
        LocalDateTime ex4=date("2019-01-27 11:00:00 PM");
        CarParkingCharges carCharges=new CarParkingCharges();
        BikeParkingCharges bikeCharges=new BikeParkingCharges();
        TruckParkingCharges truckCharges=new TruckParkingCharges();
        return Arrays.asList(
                new ParkingSlot("102",v1,et1,ex1,bikeCharges,true),
                new ParkingSlot("101",v2,et2,ex2,carCharges,true),
                            new ParkingSlot("103",v3,et3,ex3,truckCharges,true),
                            new ParkingSlot("104",v4,et4,ex4,carCharges,true)
                  );
    }

    static LocalDateTime date(String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        return LocalDateTime.parse(time, formatter);
    }
}
