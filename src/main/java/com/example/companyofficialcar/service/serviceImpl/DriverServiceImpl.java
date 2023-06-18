package com.example.companyofficialcar.service.serviceImpl;

import com.example.companyofficialcar.domain.Driver;
import com.example.companyofficialcar.repository.DriverDao;
import com.example.companyofficialcar.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverDao driverDao;

    @Autowired
    public DriverServiceImpl(DriverDao driverDao) {
        this.driverDao = driverDao;
    }

    @Override
    public Driver addDriver(Driver driver) {
        return driverDao.save(driver);
    }

    @Override
    public void deleteDriverById(Integer driverId) {
        driverDao.deleteById(driverId);
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return driverDao.saveAndFlush(driver);
    }

    @Override
    public List<Driver> findDriversByFleetId(Integer fleetId) {
        return driverDao.findByFleetId(fleetId);
    }

    @Override
    public List<Driver> findDriversByName(String name) {
        return driverDao.findByNameContaining(name);
    }

    @Override
    public List<Object[]> findCaptainDrivers(Integer userid) {
        return driverDao.findCaptainDrivers(userid);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverDao.findAll();
    }

    @Override
    public List<Object[]> getCaptionDriver(Integer captionid) {
        return driverDao.findCaptionDriver(captionid);
    }

    @Override
    public List<Object[]> getCaptionCar(Integer captionid) {
        return driverDao.findCaptionCar(captionid);
    }

    @Override
    public Driver exchangeDriverFleet(int driverid, int fleetid) {

        driverDao.updateDriverFleet(driverid,fleetid);
        return null;
    }

    @Override
    public Driver exchangeDriverName(int driverid, String name) {
        driverDao.updateDriverName(driverid,name);
        return null;
    }
}
