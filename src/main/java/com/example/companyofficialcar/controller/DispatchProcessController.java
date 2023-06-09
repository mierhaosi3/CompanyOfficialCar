package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.DispatchProcess;
import com.example.companyofficialcar.service.DispatchProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispatchprocess")
public class DispatchProcessController {
    private DispatchProcessService dispatchProcessService;

    @Autowired
    public DispatchProcessController(DispatchProcessService dispatchProcessService) {
        this.dispatchProcessService = dispatchProcessService;
    }

    @PostMapping
    public ResponseEntity<DispatchProcess> addDispatchProcess(@RequestBody DispatchProcess dispatchProcess) {
        DispatchProcess newDispatchProcess = dispatchProcessService.addDispatchProcess(dispatchProcess);
        return new ResponseEntity<>(newDispatchProcess, HttpStatus.CREATED);
    }

    @DeleteMapping("/{processId}")
    public ResponseEntity<Void> deleteDispatchProcess(@PathVariable Integer processId) {
        dispatchProcessService.deleteDispatchProcessById(processId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<DispatchProcess> updateDispatchProcess(@RequestBody DispatchProcess dispatchProcess) {
        DispatchProcess updatedDispatchProcess = dispatchProcessService.updateDispatchProcess(dispatchProcess);
        return new ResponseEntity<>(updatedDispatchProcess, HttpStatus.OK);
    }

    @GetMapping("/request/{requestId}")
    public ResponseEntity<DispatchProcess> findDispatchProcessByRequestId(@PathVariable Integer requestId) {
        DispatchProcess dispatchProcess = dispatchProcessService.findDispatchProcessByRequestId(requestId);
        if (dispatchProcess != null) {
            return new ResponseEntity<>(dispatchProcess, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/captain/{captainId}")
    public ResponseEntity<List<DispatchProcess>> findDispatchProcessesByCaptainId(@PathVariable Integer captainId) {
        List<DispatchProcess> dispatchProcesses = dispatchProcessService.findDispatchProcessesByCaptainId(captainId);
        return new ResponseEntity<>(dispatchProcesses, HttpStatus.OK);
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<DispatchProcess>> findDispatchProcessesByDriverId(@PathVariable Integer driverId) {
        List<DispatchProcess> dispatchProcesses = dispatchProcessService.findDispatchProcessesByDriverId(driverId);
        return new ResponseEntity<>(dispatchProcesses, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<DispatchProcess>> findDispatchProcessesByStatus(@PathVariable String status) {
        List<DispatchProcess> dispatchProcesses = dispatchProcessService.findDispatchProcessesByStatus(status);
        return new ResponseEntity<>(dispatchProcesses, HttpStatus.OK);
    }
}
