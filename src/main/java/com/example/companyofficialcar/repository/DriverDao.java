package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverDao extends JpaRepository<Driver,Integer> {
    // 添加司机
    Driver save(Driver driver);

    // 删除司机
    void deleteById(Integer driverId);

    // 更新司机信息
    Driver saveAndFlush(Driver driver);

    // 根据车队ID查找司机
    List<Driver> findByFleetId(Integer fleetId);

    // 根据司机姓名模糊查询司机
    List<Driver> findByNameContaining(String name);
}
