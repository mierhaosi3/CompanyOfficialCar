package com.example.companyofficialcar.domain;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "carrequest")
public class CarRequest {
    @Id
    @Column(name = "requestid")
    private Integer requestId;

    @Column(name = "applicantid")
    private Integer applicantId;

    @Column(name = "reason")
    private String reason;

    @Column(name = "passengercount")
    private Integer passengerCount;

    @Column(name = "vehicletype")
    private String vehicleType;

    @Column(name = "starttime")
    private LocalDateTime startTime;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicantid", insertable = false, updatable = false)
    private User applicant;

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(Integer passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }
}
