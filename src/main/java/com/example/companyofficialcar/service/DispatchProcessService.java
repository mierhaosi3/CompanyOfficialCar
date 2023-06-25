package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.CarRequest;
import com.example.companyofficialcar.domain.DispatchProcess;
import com.example.companyofficialcar.domain.Driver;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DispatchProcessService {
    DispatchProcess addDispatchProcess(DispatchProcess dispatchProcess);

    void deleteDispatchProcessById(Integer processId);

    DispatchProcess updateDispatchProcess(DispatchProcess dispatchProcess);

    DispatchProcess findDispatchProcessByRequestId(Integer requestId);

    List<DispatchProcess> findDispatchProcessesByCaptainId(Integer captainId);

    List<DispatchProcess> findDispatchProcessesByDriverId(Integer driverId);

    List<DispatchProcess> findDispatchProcessesByStatus(String status);

    List<Object[]> findDispatchProcessWithUserAndDriverAndUserNameAndDriver(Integer userid);

    List<DispatchProcess> getAllDispatchProcess();

    List<Object[]> getDispatchProcessWithUserAndDriver();

    List<Object[]> getDispatchProcessWithUserAndDriverAndUserName();

    DispatchProcess exchangeStatus(int driverid, String status);

    DispatchProcess exchangeDriverid(int captainid,int driverid);

    DispatchProcess exchangeVehicleid(int captainid,int vehicleid);

    Integer countDispatch();


}
