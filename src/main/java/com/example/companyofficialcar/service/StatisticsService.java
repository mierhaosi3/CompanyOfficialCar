package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.Statistics;

import java.util.List;

public interface StatisticsService {
    Statistics addStatistics(Statistics statistics);

    void deleteStatisticsById(Integer statisticsId);

    Statistics updateStatistics(Statistics statistics);

    List<Statistics> findStatisticsByFleetId(Integer fleetId);

    List<Statistics> findStatisticsByDriverId(Integer driverId);

    List<Statistics> getAllStatistics();

    List<Object[]> getAllStatisticsWithFleetAndDriver();

}
