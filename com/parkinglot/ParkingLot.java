package com.parkinglot;

import java.util.List;
import java.util.Optional;

class ParkingLot
{
 List<ParkingSlot> parkingSlots;
 boolean isSlotAvailable(VehicleType vehicleType){
  Optional<ParkingSlot> any = parkingSlots.stream().filter(x -> x.vehicle.vehicleType.equals(vehicleType) && x.isAvailable)
          .findAny();
if (any.isPresent())return  true;
return false;
 }
 }