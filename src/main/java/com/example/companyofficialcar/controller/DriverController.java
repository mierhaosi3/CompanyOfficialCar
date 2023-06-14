package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.Driver;
import com.example.companyofficialcar.service.DriverService;
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



    @PostMapping("/{driverid}/name")
    public ResponseEntity<String> exchangeDriverName(@PathVariable int driverid, @RequestBody String name) throws UnsupportedEncodingException {

        String decodedfleetname = URLDecoder.decode(name, "UTF-8");
        decodedfleetname = decodedfleetname.trim(); // 去除字符串末尾的空格和等号

        // 使用正则表达式匹配并移除末尾的等号
        Pattern pattern = Pattern.compile("(.*?)=$");
        Matcher matcher = pattern.matcher(decodedfleetname);
        if (matcher.find()) {
            decodedfleetname = matcher.group(1);
        }
        System.out.println(decodedfleetname);
        driverService.exchangeDriverName(driverid, decodedfleetname);
        return ResponseEntity.ok("exchangeDriverName");
    }

    @PostMapping(value = "/{driverid}/fleetid", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> exchangeDriverFleet(@PathVariable int driverid, @RequestBody MultiValueMap<String, String> formData) {
        int fleetid = Integer.parseInt(formData.getFirst("fleetid"));
        System.out.println(fleetid);
        driverService.exchangeDriverFleet(driverid, fleetid);
        return ResponseEntity.ok("exchangeDriverFleet");
    }


    @GetMapping("/name")
    public ResponseEntity<List<Driver>> getDriversByName(@RequestParam("name") String name) {
        List<Driver> drivers = driverService.findDriversByName(name);
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/All")
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }
}