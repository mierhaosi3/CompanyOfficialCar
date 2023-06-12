package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);

    void deleteVehicleById(Integer vehicleId);

    Vehicle updateVehicle(Vehicle vehicle);

    List<Vehicle> findVehiclesByFleetId(Integer fleetId);

    List<Vehicle> findVehiclesByVehicletype(String vehicletype);

    List<Vehicle> getAllVehicle();

    List<Object[]> getAllVehicleWithUserAndDriver();

    Vehicle updateVehiclefleetid(int vehicleid,int fleetid);

    Vehicle updateVehicleType(int vehicleid,String vehicletype);

}
