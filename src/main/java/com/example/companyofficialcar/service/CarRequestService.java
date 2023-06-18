package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.CarRequest;
import com.example.companyofficialcar.domain.DispatchProcess;
import com.example.companyofficialcar.domain.Driver;

import java.util.List;

public interface CarRequestService {
    CarRequest addCarRequest(CarRequest carRequest);

    void deleteCarRequestById(Integer requestId);

    CarRequest updateCarRequest(CarRequest carRequest);

    List<CarRequest> findCarRequestsByApplicantId(Integer applicantId);

    List<CarRequest> findCarRequestsByStatus(String status);

    List<CarRequest> getAllCarRequest();

    List<Object[]> getCarRequestsWithApplicantUsername();

    List<Object[]>findCarRequestsWithApplicantUsernameByApplicantId(Integer ApplicantId);

    CarRequest exchangeStatus(int driverid, String name);

    Integer countCarRequests();
}
