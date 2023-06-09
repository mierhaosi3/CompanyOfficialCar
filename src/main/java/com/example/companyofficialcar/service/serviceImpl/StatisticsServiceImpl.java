package com.example.companyofficialcar.service.serviceImpl;

import com.example.companyofficialcar.domain.Statistics;
import com.example.companyofficialcar.repository.StatisticsDao;
import com.example.companyofficialcar.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    private final StatisticsDao statisticsDao;

    @Autowired
    public StatisticsServiceImpl(StatisticsDao statisticsDao) {
        this.statisticsDao = statisticsDao;
    }

    @Override
    public Statistics addStatistics(Statistics statistics) {
        return statisticsDao.save(statistics);
    }

    @Override
    public void deleteStatisticsById(Integer statisticsId) {
        statisticsDao.deleteById(statisticsId);
    }

    @Override
    public Statistics updateStatistics(Statistics statistics) {
        return statisticsDao.saveAndFlush(statistics);
    }

    @Override
    public List<Statistics> findStatisticsByFleetId(Integer fleetId) {
        return statisticsDao.findByFleetId(fleetId);
    }

    @Override
    public List<Statistics> findStatisticsByDriverId(Integer driverId) {
        return statisticsDao.findByDriverId(driverId);
    }
}
