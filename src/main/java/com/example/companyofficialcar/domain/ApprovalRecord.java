package com.example.companyofficialcar.domain;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "approvalrecord")
public class ApprovalRecord {
    @Id
    @Column(name = "recordid")
    private Integer recordId;

    @Column(name = "requestid")
    private Integer requestId;

    @Column(name = "approverid")
    private Integer approverId;

    @Column(name = "approvaltime")
    private LocalDateTime approvalTime;

    @Column(name = "result")
    private String result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requestid", insertable = false, updatable = false)
    private CarRequest carRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approverid", insertable = false, updatable = false)
    private User approver;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getApproverId() {
        return approverId;
    }

    public void setApproverId(Integer approverId) {
        this.approverId = approverId;
    }

    public LocalDateTime getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(LocalDateTime approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public CarRequest getCarRequest() {
        return carRequest;
    }

    public void setCarRequest(CarRequest carRequest) {
        this.carRequest = carRequest;
    }

    public User getApprover() {
        return approver;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }
}
