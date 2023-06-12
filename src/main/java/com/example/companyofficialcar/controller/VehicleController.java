package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.Vehicle;
import com.example.companyofficialcar.service.VehicleService;
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


    @PostMapping("/{vehicleid}/VehicleType")
    public ResponseEntity<String> exchangeVehicleType(@PathVariable int vehicleid, @RequestBody String vehicletype) throws UnsupportedEncodingException {

        String decodedfleetname = URLDecoder.decode(vehicletype, "UTF-8");
        decodedfleetname = decodedfleetname.trim(); // 去除字符串末尾的空格和等号

        // 使用正则表达式匹配并移除末尾的等号
        Pattern pattern = Pattern.compile("(.*?)=$");
        Matcher matcher = pattern.matcher(decodedfleetname);
        if (matcher.find()) {
            decodedfleetname = matcher.group(1);
        }
        System.out.println(decodedfleetname);
        vehicleService.updateVehicleType(vehicleid, decodedfleetname);
        return ResponseEntity.ok("exchangeVehicleType");
    }

    @PostMapping(value = "/{vehicleid}/fleetid", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> exchangeVehicleFleet(@PathVariable int vehicleid, @RequestBody MultiValueMap<String, String> formData) {
        int fleetid = Integer.parseInt(formData.getFirst("fleetid"));
        System.out.println(fleetid);
        vehicleService.updateVehiclefleetid(vehicleid, fleetid);
        return ResponseEntity.ok("exchangeVehicleFleet");
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
