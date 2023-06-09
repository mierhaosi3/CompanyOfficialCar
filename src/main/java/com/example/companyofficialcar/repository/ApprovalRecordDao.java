package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.ApprovalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovalRecordDao extends JpaRepository<ApprovalRecord, Integer> {
    // 添加审核记录
    ApprovalRecord save(ApprovalRecord approvalRecord);

    // 删除审核记录
    void deleteById(Integer recordId);

    // 更新审核记录信息
    ApprovalRecord saveAndFlush(ApprovalRecord approvalRecord);

    // 根据申请ID查找审核记录
    List<ApprovalRecord> findByRequestId(Integer requestId);

    @Query("SELECT ar, cr, u.username " +
            "FROM ApprovalRecord ar " +
            "JOIN CarRequest cr ON ar.requestId = cr.requestId " +
            "JOIN User u ON ar.approverId = u.userid")
    List<Object[]> findAllApprovalRecords();
}
