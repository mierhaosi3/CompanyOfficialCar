package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.ApprovalRecord;

import java.util.List;

public interface ApprovalRecordService {
    ApprovalRecord addApprovalRecord(ApprovalRecord approvalRecord);

    void deleteApprovalRecordById(Integer recordId);

    ApprovalRecord updateApprovalRecord(ApprovalRecord approvalRecord);

    List<ApprovalRecord> findApprovalRecordsByRequestId(Integer requestId);

}
