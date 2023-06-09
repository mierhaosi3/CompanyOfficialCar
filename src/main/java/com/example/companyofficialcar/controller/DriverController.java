package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.Driver;
import com.example.companyofficialcar.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
        Driver createdDriver = driverService.addDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDriver);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable("id") Integer driverId) {
        driverService.deleteDriverById(driverId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable("id") Integer driverId, @RequestBody Driver driver) {
        driver.setDriverId(driverId);
        Driver updatedDriver = driverService.updateDriver(driver);
        return ResponseEntity.ok(updatedDriver);
    }

    @GetMapping("/fleet/{fleetId}")
    public ResponseEntity<List<Driver>> getDriversByFleetId(@PathVariable("fleetId") Integer fleetId) {
        List<Driver> drivers = driverService.findDriversByFleetId(fleetId);
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Driver>> getDriversByName(@PathVariable("name") String name) {
        List<Driver> drivers = driverService.findDriversByName(name);
        return ResponseEntity.ok(drivers);
    }
}