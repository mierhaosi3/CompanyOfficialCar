package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.CarRequest;
import com.example.companyofficialcar.service.CarRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @PostMapping("/{requestid}/status")
    public ResponseEntity<String> exchangeDriverName(@PathVariable int requestid, @RequestBody String status) throws UnsupportedEncodingException {

        String decodedfleetname = URLDecoder.decode(status, "UTF-8");
        decodedfleetname = decodedfleetname.trim(); // 去除字符串末尾的空格和等号

        // 使用正则表达式匹配并移除末尾的等号
        Pattern pattern = Pattern.compile("(.*?)=$");
        Matcher matcher = pattern.matcher(decodedfleetname);
        if (matcher.find()) {
            decodedfleetname = matcher.group(1);
        }
        System.out.println(decodedfleetname);
        carRequestService.exchangeStatus(requestid, decodedfleetname);
        return ResponseEntity.ok("exchangeDriverName");
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<CarRequest>> getCarRequestsByStatus(@PathVariable String status) {
        List<CarRequest> carRequests = carRequestService.findCarRequestsByStatus(status);
        return ResponseEntity.ok(carRequests);
    }
    @GetMapping("/All") 
    public List<CarRequest> getAllDrivers() {
        return carRequestService.getAllCarRequest();
    }

    @GetMapping("/Allprofile")
    public List<Object[]> getAllStatisticsWithFleetAndDriver(){
        return carRequestService.getCarRequestsWithApplicantUsername();
    }
}
