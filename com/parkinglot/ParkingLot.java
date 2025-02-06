package com.parkinglot;

import java.util.*;

class ParkingLot
{
 private Map<VehicleType, List<ParkingSlot>> slots;

 public ParkingLot(int carSlots, int bikeSlots, int truckSlots) {
  slots = new HashMap<>();
  slots.put(VehicleType.CAR, createSlots(VehicleType.CAR, carSlots));
  slots.put(VehicleType.BIKE, createSlots(VehicleType.BIKE, bikeSlots));
  slots.put(VehicleType.TRUCK, createSlots(VehicleType.TRUCK, truckSlots));
 }

 private List<ParkingSlot> createSlots(VehicleType type, int count) {
  List<ParkingSlot> list = new ArrayList<>();
  for (int i = 0; i < count; i++) {
   list.add(new ParkingSlot(type));
  }
  return list;
 }

 public Ticket parkVehicle(Vehicle vehicle) {
  List<ParkingSlot> availableSlots = slots.get(vehicle.getType());
  for (ParkingSlot slot : availableSlots) {
   if (slot.isAvailable()) {
    slot.park();
    return new Ticket(vehicle);
   }
  }
  throw new RuntimeException("No available slots for " + vehicle.getType());
 }

 public void vacateSlot(Ticket ticket) {
  ticket.exit();
  ticket.calculateFee();
  System.out.println("Total fee: " + ticket.getFee());

  List<ParkingSlot> slotList = slots.get(ticket.vehicle.getType());
  for (ParkingSlot slot : slotList) {
   if (!slot.isAvailable()) {
    slot.vacate();
    break;
   }
  }
 }
 }