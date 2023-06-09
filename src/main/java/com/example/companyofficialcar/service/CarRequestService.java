package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.CarRequest;

import java.util.List;

public interface CarRequestService {
    CarRequest addCarRequest(CarRequest carRequest);

    void deleteCarRequestById(Integer requestId);

    CarRequest updateCarRequest(CarRequest carRequest);

    List<CarRequest> findCarRequestsByApplicantId(Integer applicantId);

    List<CarRequest> findCarRequestsByStatus(String status);
}
