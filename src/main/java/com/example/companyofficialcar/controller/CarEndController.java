package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.CarEnd;
import com.example.companyofficialcar.service.CarEndService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carend")
public class CarEndController {
    private CarEndService carEndService;

    @Autowired
    public CarEndController(CarEndService carEndService) {
        this.carEndService = carEndService;
    }

    @PostMapping("/")
    public ResponseEntity<CarEnd> addCarEnd(@RequestBody CarEnd carEnd) {
        CarEnd newCarEnd = carEndService.addCarEnd(carEnd);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCarEnd);
    }

    @DeleteMapping("/{endId}")
    public ResponseEntity<Void> deleteCarEnd(@PathVariable Integer endId) {
        carEndService.deleteCarEndById(endId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/")
    public ResponseEntity<CarEnd> updateCarEnd(@RequestBody CarEnd carEnd) {
        CarEnd updatedCarEnd = carEndService.updateCarEnd(carEnd);
        return ResponseEntity.ok(updatedCarEnd);
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<CarEnd> findCarEndByRequestId(@PathVariable Integer requestId) {
        CarEnd carEnd = carEndService.findCarEndByRequestId(requestId);
        if (carEnd != null) {
            return ResponseEntity.ok(carEnd);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/All")
    public List<CarEnd> getAllDrivers() {
        return carEndService.getAllCarEnd();
    }

    @GetMapping("/Allprofile")
    public List<Object[]> getAllStatisticsWithFleetAndDriver(){
        return carEndService.getAllCarEndsWithUsername();
    }
}
