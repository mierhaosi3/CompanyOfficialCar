package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.CarRequest;
import com.example.companyofficialcar.service.CarRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrequests")
public class CarRequestController {
    private CarRequestService carRequestService;

    @Autowired
    public CarRequestController(CarRequestService carRequestService) {
        this.carRequestService = carRequestService;
    }

    @PostMapping
    public ResponseEntity<CarRequest> addCarRequest(@RequestBody CarRequest carRequest) {
        CarRequest addedCarRequest = carRequestService.addCarRequest(carRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCarRequest);
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> deleteCarRequest(@PathVariable Integer requestId) {
        carRequestService.deleteCarRequestById(requestId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{requestId}")
    public ResponseEntity<CarRequest> updateCarRequest(@PathVariable Integer requestId, @RequestBody CarRequest carRequest) {
        carRequest.setRequestId(requestId);
        CarRequest updatedCarRequest = carRequestService.updateCarRequest(carRequest);
        return ResponseEntity.ok(updatedCarRequest);
    }

    @GetMapping("/applicant/{applicantId}")
    public ResponseEntity<List<CarRequest>> getCarRequestsByApplicantId(@PathVariable Integer applicantId) {
        List<CarRequest> carRequests = carRequestService.findCarRequestsByApplicantId(applicantId);
        return ResponseEntity.ok(carRequests);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<CarRequest>> getCarRequestsByStatus(@PathVariable String status) {
        List<CarRequest> carRequests = carRequestService.findCarRequestsByStatus(status);
        return ResponseEntity.ok(carRequests);
    }
}
