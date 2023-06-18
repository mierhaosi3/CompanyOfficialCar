package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.ApprovalRecord;
import com.example.companyofficialcar.service.ApprovalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/approvalrecords")
public class ApprovalRecordController {
    private final ApprovalRecordService approvalRecordService;

    @Autowired
    public ApprovalRecordController(ApprovalRecordService approvalRecordService) {

        this.approvalRecordService = approvalRecordService;
    } 

    @PostMapping("/add")
    public ResponseEntity<ApprovalRecord> addApprovalRecord(@RequestBody ApprovalRecord approvalRecord) {
        Integer requestId = approvalRecord.getRequestId();
        approvalRecord.setRequestId(requestId);

        ApprovalRecord addedRecord = approvalRecordService.addApprovalRecord(approvalRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedRecord);
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<Void> deleteApprovalRecordById(@PathVariable Integer recordId) {
        approvalRecordService.deleteApprovalRecordById(recordId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{recordId}")
    public ResponseEntity<ApprovalRecord> updateApprovalRecord(@PathVariable Integer recordId, @RequestBody ApprovalRecord approvalRecord) {
        ApprovalRecord updatedRecord = approvalRecordService.updateApprovalRecord(approvalRecord);
        return ResponseEntity.ok(updatedRecord);
    }

    @GetMapping("/request/{requestId}")
    public ResponseEntity<List<ApprovalRecord>> findApprovalRecordsByRequestId(@PathVariable Integer requestId) {
        List<ApprovalRecord> approvalRecords = approvalRecordService.findApprovalRecordsByRequestId(requestId);
        return ResponseEntity.ok(approvalRecords);
    }
    @GetMapping("/All")
    public List<ApprovalRecord> getAllDrivers() {
        return approvalRecordService.getAllApprovalRecord();
    }

    @GetMapping("/Allprofile")
    public List<Object[]> getAllStatisticsWithFleetAndDriver(){
        return approvalRecordService.getAllApprovalRecords();
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Integer>> getCarRequestCount() {
        Integer count = approvalRecordService.countApprovalRecord();
        Map<String, Integer> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }
}
