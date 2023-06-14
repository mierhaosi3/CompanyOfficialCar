package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.CarRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT cr, u.username FROM CarRequest cr JOIN User u ON cr.applicantId = u.userid")
    List<Object[]> findCarRequestsWithApplicantUsername();


    @Query("SELECT cr, u.username FROM CarRequest cr JOIN User u ON cr.applicantId = u.userid WHERE cr.applicantId = :applicantid")
    List<Object[]> findCarRequestsWithApplicantUsernameByApplicantId(@Param("applicantid") Integer applicantid);

    @Modifying
    @Transactional
    @Query("UPDATE CarRequest cr SET cr.status = :status WHERE cr.requestId = :requestid")
    void updateStatus(@Param("requestid") int requestid, @Param("status") String status);
}
