package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.Vehicle;
import com.example.companyofficialcar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("id") Integer vehicleId) {
        vehicleService.deleteVehicleById(vehicleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") Integer vehicleId, @RequestBody Vehicle vehicle) {
        vehicle.setVehicleid(vehicleId);
        Vehicle updatedVehicle = vehicleService.updateVehicle(vehicle);
        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
    }

    @GetMapping("/fleet/{fleetId}")
    public ResponseEntity<List<Vehicle>> getVehiclesByFleetId(@PathVariable("fleetId") Integer fleetId) {
        List<Vehicle> vehicles = vehicleService.findVehiclesByFleetId(fleetId);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/type/{vehicleType}")
    public ResponseEntity<List<Vehicle>> getVehiclesByVehicleType(@PathVariable("vehicleType") String vehicleType) {
        List<Vehicle> vehicles = vehicleService.findVehiclesByVehicletype(vehicleType);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
    @GetMapping("/All")
    public List<Vehicle> getAllDrivers() {
        return vehicleService.getAllVehicle();
    }

    @GetMapping("/Allprofile")
    public List<Object[]> getAllStatisticsWithFleetAndDriver(){
        return vehicleService.getAllVehicleWithUserAndDriver();
    }
}
