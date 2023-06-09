package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    @Query("SELECT v, f.captain.userid, u.username " +
            "FROM Vehicle v " +
            "JOIN Fleet f ON v.fleetid = f.fleetid " +
            "JOIN User u ON f.captain.userid = u.userid")
    List<Object[]> findAllWithDriverAndUser();


    @Query("SELECT v, f.captain.userid, u.username " +
            "FROM Vehicle v " +
            "JOIN Fleet f ON v.fleetid = f.fleetid " +
            "JOIN User u ON f.captain.userid = u.userid " +
            "WHERE v.fleetid = :fleetid")
    List<Object[]> findFleetName(@Param("fleetid") int fleetid);

    @Modifying
    @Transactional
    @Query("UPDATE Vehicle v SET v.fleetid = :fleetid WHERE v.vehicleid = :vehicleid")
    void updateVehiclefleetid(@Param("vehicleid") int vehicleid, @Param("fleetid") int fleetid);

    @Modifying
    @Transactional
    @Query("UPDATE Vehicle v SET v.vehicletype = :vehicletype WHERE v.vehicleid = :vehicleid")
    void updateVehicleType(@Param("vehicleid") int vehicleid, @Param("vehicletype") String vehicletype);
}
