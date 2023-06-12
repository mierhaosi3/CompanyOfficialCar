package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.Driver;
import com.example.companyofficialcar.domain.Vehicle;

import java.util.List;

public interface DriverService {
    Driver addDriver(Driver driver);

    void deleteDriverById(Integer driverId);

    Driver updateDriver(Driver driver);

    List<Driver> findDriversByFleetId(Integer fleetId);

    List<Driver> findDriversByName(String name);

    List<Driver> getAllDrivers();

    Driver exchangeDriverFleet(int driverid, int fleetid);

    Driver exchangeDriverName(int driverid,String name);
}
