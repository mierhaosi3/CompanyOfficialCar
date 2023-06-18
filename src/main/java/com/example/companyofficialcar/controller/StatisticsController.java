package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.Statistics;
import com.example.companyofficialcar.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    private StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @PostMapping("/add")
    public Statistics addStatistics(@RequestBody Statistics statistics) {
        Integer statustucsid = statistics.getStatisticsId();
        statistics.setStatisticsId(statustucsid);
        System.out.println(statustucsid);
        return statisticsService.addStatistics(statistics);
    }

    @DeleteMapping("/{id}")
    public void deleteStatisticsById(@PathVariable("id") Integer statisticsId) {
        statisticsService.deleteStatisticsById(statisticsId);
    }

    @PutMapping("/{id}")
    public Statistics updateStatistics(@PathVariable("id") Integer statisticsId, @RequestBody Statistics statistics) {
        statistics.setStatisticsId(statisticsId);
        return statisticsService.updateStatistics(statistics);
    }

    @GetMapping("/fleet/{fleetId}")
    public List<Statistics> findStatisticsByFleetId(@PathVariable("fleetId") Integer fleetId) {
        return statisticsService.findStatisticsByFleetId(fleetId);
    }

    @GetMapping("/driver/{driverId}")
    public List<Statistics> findStatisticsByDriverId(@PathVariable("driverId") Integer driverId) {
        return statisticsService.findStatisticsByDriverId(driverId);
    }

    @GetMapping("/All")
    public List<Statistics> getAllDrivers() {
        return statisticsService.getAllStatistics();
    }

    @GetMapping("/Allprofile")
    public List<Object[]> getAllStatisticsWithFleetAndDriver(){
        return statisticsService.getAllStatisticsWithFleetAndDriver();
    }

}
