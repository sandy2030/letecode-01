package com.parkinglot;

import java.time.LocalDateTime;

class ParkingSlot
{
 String parkingSlotId;
 Vehicle vehicle;
 LocalDateTime entryTime;
 LocalDateTime exitTime;
 IParkingCharges parkingCharges;

 boolean isAvailable;
 ParkingSlot(String parkingSlotId,Vehicle vehicle,LocalDateTime entryTime,LocalDateTime exitTime,IParkingCharges parkingCharges,boolean isAvailable){
     this.parkingSlotId=parkingSlotId;
     this.vehicle=vehicle;
     this.entryTime=entryTime;
     this.exitTime=exitTime;
      this.parkingCharges= parkingCharges;
      this.isAvailable=isAvailable;
 }
public double charges(){
  return parkingCharges.charge();
}

}