package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsDao extends JpaRepository<Statistics, Integer> {
    // 添加统计数据
    Statistics save(Statistics statistics);

    // 删除统计数据
    void deleteById(Integer statisticsId);

    // 更新统计数据信息
    Statistics saveAndFlush(Statistics statistics);

    // 根据车队ID查找统计数据
    List<Statistics> findByFleetId(Integer fleetId);

    // 根据司机ID查找统计数据
    List<Statistics> findByDriverId(Integer driverId);

    @Query("SELECT s.statisticsId, f.fleetname,  d.name,  s.month, s.trips FROM Statistics s LEFT JOIN Fleet f ON s.fleetId = f.fleetid LEFT JOIN Driver d ON s.driverId = d.driverId")
    List<Object[]> findAllWithFleetAndDriver();
}
