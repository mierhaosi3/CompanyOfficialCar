package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.DispatchProcess;

import java.util.List;

public interface DispatchProcessService {
    DispatchProcess addDispatchProcess(DispatchProcess dispatchProcess);

    void deleteDispatchProcessById(Integer processId);

    DispatchProcess updateDispatchProcess(DispatchProcess dispatchProcess);

    DispatchProcess findDispatchProcessByRequestId(Integer requestId);

    List<DispatchProcess> findDispatchProcessesByCaptainId(Integer captainId);

    List<DispatchProcess> findDispatchProcessesByDriverId(Integer driverId);

    List<DispatchProcess> findDispatchProcessesByStatus(String status);
}
