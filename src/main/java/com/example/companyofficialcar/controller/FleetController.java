package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.Fleet;
import com.example.companyofficialcar.service.FleetService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fleet")
public class FleetController {
    @Resource
    private FleetService fleetService;

    public FleetController(FleetService fleetService) {
        this.fleetService = fleetService;
    }
    @GetMapping("/profile")
    public List<Object[]> getFleetProfileDetails() {
        return fleetService.getDriver();
    }
    @PutMapping("/{fleetid}/captain/{captainid}")
    public Fleet exchangeFleetCaptain(@PathVariable int fleetid, @PathVariable int captainid) {
        return fleetService.exchangeFleetID(fleetid, captainid);
    }

    @PutMapping("/{fleetid}/name/{fleetname}")
    public Fleet exchangeFleetName(@PathVariable int fleetid, @PathVariable String name) {
        return fleetService.exchangeFleetName(name, fleetid);
    }

    @GetMapping("/delete/{fleetid}")
    public void deleteFleet(@PathVariable int fleetid) {
        fleetService.deleteFleet(fleetid);
    }

    @PostMapping("/insert")
    public Fleet insertFleet(@RequestBody Fleet fleet) {
        return fleetService.insertFleet(fleet);
    }

    @GetMapping("/All")
    public List<Fleet> getAllDrivers() {
        return fleetService.getAllFleet();
    }

    @GetMapping("/Allprofile")
    public List<Object[]> getAllStatisticsWithFleetAndDriver(){
        return fleetService.getAllFleetAndUser();
    }
}
