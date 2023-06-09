package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.CarRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRequestDao extends JpaRepository<CarRequest, Integer> {
    // 添加用车申请
    CarRequest save(CarRequest carRequest);

    // 删除用车申请
    void deleteById(Integer requestId);

    // 更新用车申请信息
    CarRequest saveAndFlush(CarRequest carRequest);

    // 根据申请人ID查找用车申请
    List<CarRequest> findByApplicantId(Integer applicantId);

    // 根据申请状态查找用车申请
    List<CarRequest> findByStatus(String status);
}
