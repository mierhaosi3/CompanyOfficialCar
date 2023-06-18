package com.example.companyofficialcar.service.serviceImpl;

import com.example.companyofficialcar.domain.DispatchProcess;
import com.example.companyofficialcar.repository.DispatchProcessDao;
import com.example.companyofficialcar.service.DispatchProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchProcessServiceImpl implements DispatchProcessService {
    private final DispatchProcessDao dispatchProcessDao;

    @Autowired
    public DispatchProcessServiceImpl(DispatchProcessDao dispatchProcessDao) {
        this.dispatchProcessDao = dispatchProcessDao;
    }

    @Override
    public DispatchProcess addDispatchProcess(DispatchProcess dispatchProcess) {
        return dispatchProcessDao.save(dispatchProcess);
    }

    @Override
    public void deleteDispatchProcessById(Integer processId) {
        dispatchProcessDao.deleteById(processId);
    }

    @Override
    public DispatchProcess updateDispatchProcess(DispatchProcess dispatchProcess) {
        return dispatchProcessDao.saveAndFlush(dispatchProcess);
    }

    @Override
    public DispatchProcess findDispatchProcessByRequestId(Integer requestId) {
        return dispatchProcessDao.findByRequestId(requestId);
    }

    @Override
    public List<DispatchProcess> findDispatchProcessesByCaptainId(Integer captainId) {
        return dispatchProcessDao.findByCaptainId(captainId);
    }

    @Override
    public List<DispatchProcess> findDispatchProcessesByDriverId(Integer driverId) {
        return dispatchProcessDao.findByDriverId(driverId);
    }

    @Override
    public List<DispatchProcess> findDispatchProcessesByStatus(String status) {
        return dispatchProcessDao.findByStatus(status);
    }

    @Override
    public List<Object[]> findDispatchProcessWithUserAndDriverAndUserNameAndDriver(Integer userid) {
        return dispatchProcessDao.findDispatchProcessWithUserAndDriverAndUserNameAndDriver(userid);
    }

    @Override
    public List<DispatchProcess> getAllDispatchProcess() {
        return dispatchProcessDao.findAll();
    }

    @Override
    public List<Object[]> getDispatchProcessWithUserAndDriver() {
        return dispatchProcessDao.findDispatchProcessWithUserAndDriver();
    }

    @Override
    public List<Object[]> getDispatchProcessWithUserAndDriverAndUserName() {
        return dispatchProcessDao.findDispatchProcessWithUserAndDriverAndUserName();
    }

    @Override
    public DispatchProcess exchangeStatus(int driverid, String status) {
        dispatchProcessDao.updateStatus(driverid,status);
        return null;
    }

    @Override
    public DispatchProcess exchangeDriverid(int captainid, int driverid) {
        dispatchProcessDao.updatedDriverId(captainid,driverid);
        return null;
    }

    @Override
    public DispatchProcess exchangeVehicleid(int captainid, int vehicleid) {
        dispatchProcessDao.updateVehicleid(captainid,vehicleid);
        return null;
    }
}
