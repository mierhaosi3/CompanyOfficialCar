package com.example.companyofficialcar.service.serviceImpl;

import com.example.companyofficialcar.domain.ApprovalRecord;
import com.example.companyofficialcar.repository.ApprovalRecordDao;
import com.example.companyofficialcar.service.ApprovalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalRecordServiceImpl implements ApprovalRecordService {
    private final ApprovalRecordDao approvalRecordDao;

    @Autowired
    public ApprovalRecordServiceImpl(ApprovalRecordDao approvalRecordRepository) {
        this.approvalRecordDao = approvalRecordRepository;
    }

    @Override
    public ApprovalRecord addApprovalRecord(ApprovalRecord approvalRecord) {
        return approvalRecordDao.save(approvalRecord);
    }

    @Override
    public void deleteApprovalRecordById(Integer recordId) {
        approvalRecordDao.deleteById(recordId);
    }

    @Override
    public ApprovalRecord updateApprovalRecord(ApprovalRecord approvalRecord) {
        return approvalRecordDao.saveAndFlush(approvalRecord);
    }

    @Override
    public List<ApprovalRecord> findApprovalRecordsByRequestId(Integer requestId) {
        return approvalRecordDao.findByRequestId(requestId);
    }

    @Override
    public List<ApprovalRecord> getAllApprovalRecord() {
        return approvalRecordDao.findAll();
    }

    @Override
    public List<Object[]> getAllApprovalRecords() {
        return approvalRecordDao.findAllApprovalRecords();
    }

    @Override
    public Integer countApprovalRecord() {
        return approvalRecordDao.countApprovalRecord();
    }


}

