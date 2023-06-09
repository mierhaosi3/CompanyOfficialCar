package com.example.companyofficialcar.domain;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "carend")
public class CarEnd {
    @Id
    @Column(name = "endid")
    private Integer endId;

    @Column(name = "requestid")
    private Integer requestId;

    @Column(name = "endtime")
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requestid", insertable = false, updatable = false)
    private CarRequest carRequest;

    public Integer getEndId() {
        return endId;
    }

    public void setEndId(Integer endId) {
        this.endId = endId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public CarRequest getCarRequest() {
        return carRequest;
    }

    public void setCarRequest(CarRequest carRequest) {
        this.carRequest = carRequest;
    }
}
