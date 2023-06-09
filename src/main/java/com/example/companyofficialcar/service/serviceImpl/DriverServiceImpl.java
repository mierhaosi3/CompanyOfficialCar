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
    public List<Driver> getAllDrivers() {
        return driverDao.findAll();
    }
}
