package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.Driver;

import java.util.List;

public interface DriverService {
    Driver addDriver(Driver driver);

    void deleteDriverById(Integer driverId);

    Driver updateDriver(Driver driver);

    List<Driver> findDriversByFleetId(Integer fleetId);

    List<Driver> findDriversByName(String name);
}
