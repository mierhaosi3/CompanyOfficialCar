package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle,Integer> {
    // 添加车辆
    Vehicle save(Vehicle vehicle);

    // 删除车辆
    void deleteById(Integer vehicleid);

    // 更新车辆信息
    Vehicle saveAndFlush(Vehicle vehicle);

    // 根据车队ID查找车辆
    List<Vehicle> findByFleetid(Integer fleetid);

    // 根据车辆类型查找车辆
    List<Vehicle> findByVehicletype(String vehicletype);

    @Query("SELECT s.statisticsId, f.fleetname, u.username, d.name, s.month, s.trips " +
            "FROM Statistics s " +
            "LEFT JOIN Fleet f ON s.fleetId = f.fleetid " +
            "LEFT JOIN User u ON f.captainid = u.userid " +
            "LEFT JOIN Driver d ON s.driverId = d.driverId")
    List<Object[]> findAllWithDriverAndUser();
}
