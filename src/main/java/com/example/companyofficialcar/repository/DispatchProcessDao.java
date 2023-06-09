package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.DispatchProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispatchProcessDao extends JpaRepository<DispatchProcess, Integer> {
    // 添加派车流程
    DispatchProcess save(DispatchProcess dispatchProcess);

    // 删除派车流程
    void deleteById(Integer processId);

    // 更新派车流程信息
    DispatchProcess saveAndFlush(DispatchProcess dispatchProcess);

    // 根据申请ID查找派车流程
    DispatchProcess findByRequestId(Integer requestId);

    // 根据队长ID查找派车流程
    List<DispatchProcess> findByCaptainId(Integer captainId);

    // 根据司机ID查找派车流程
    List<DispatchProcess> findByDriverId(Integer driverId);

    // 根据状态查找派车流程
    List<DispatchProcess> findByStatus(String status);

    @Query("SELECT dp, u.username, d.name FROM DispatchProcess dp " +
            "JOIN User u ON dp.captainId = u.userid " +
            "JOIN Driver d ON dp.driverId = d.driverId")
    List<Object[]> findDispatchProcessWithUserAndDriver();
}

