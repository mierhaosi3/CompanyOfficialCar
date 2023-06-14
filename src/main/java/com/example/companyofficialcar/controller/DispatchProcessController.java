package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.DispatchProcess;
import com.example.companyofficialcar.service.DispatchProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @PostMapping("/{processid}/status")
    public ResponseEntity<String> exchangeDriverName(@PathVariable int processid, @RequestBody String status) throws UnsupportedEncodingException {

        String decodedfleetname = URLDecoder.decode(status, "UTF-8");
        decodedfleetname = decodedfleetname.trim(); // 去除字符串末尾的空格和等号

        // 使用正则表达式匹配并移除末尾的等号
        Pattern pattern = Pattern.compile("(.*?)=$");
        Matcher matcher = pattern.matcher(decodedfleetname);
        if (matcher.find()) {
            decodedfleetname = matcher.group(1);
        }
        System.out.println(decodedfleetname);
        dispatchProcessService.exchangeStatus(processid, decodedfleetname);
        return ResponseEntity.ok("exchangeDriverName");
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

    @GetMapping("/All")
    public List<DispatchProcess> getAllDrivers() {
        return dispatchProcessService.getAllDispatchProcess();
    }

    @GetMapping("/Allprofile")
    public List<Object[]> getAllStatisticsWithFleetAndDriver(){
        return dispatchProcessService.getDispatchProcessWithUserAndDriver();
    }
}
