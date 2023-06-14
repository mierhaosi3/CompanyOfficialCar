package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.Fleet;
import com.example.companyofficialcar.service.FleetService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    @PostMapping("/{fleetid}/captain")
    public Fleet exchangeFleetCaptain(@PathVariable int fleetid, @PathVariable int captainid) {
        return fleetService.exchangeFleetID(fleetid, captainid);
    }

    @GetMapping("/fleetname")
    public List<Object[]> getUserProfileDetailsStaff(@RequestParam("fleetname") String fleetname) {
        return fleetService.getCaptainNameDetails(fleetname);
    }

    @PostMapping("/{fleetid}/fleetname")
    public ResponseEntity<String> exchangeFleetName(@RequestBody String fleetname, @PathVariable int fleetid) throws UnsupportedEncodingException {

        String decodedfleetname = URLDecoder.decode(fleetname, "UTF-8");
        decodedfleetname = decodedfleetname.trim(); // 去除字符串末尾的空格和等号

        // 使用正则表达式匹配并移除末尾的等号
        Pattern pattern = Pattern.compile("(.*?)=$");
        Matcher matcher = pattern.matcher(decodedfleetname);
        if (matcher.find()) {
            decodedfleetname = matcher.group(1);
        }
        System.out.println(decodedfleetname);
        System.out.println(123);
        fleetService.exchangename(fleetid, decodedfleetname);
        return ResponseEntity.ok("decodedfleetname");
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
