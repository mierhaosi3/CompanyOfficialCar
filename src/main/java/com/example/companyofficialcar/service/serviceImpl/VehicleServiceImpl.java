package com.example.companyofficialcar.service.serviceImpl;

import com.example.companyofficialcar.domain.Vehicle;
import com.example.companyofficialcar.repository.VehicleDao;
import com.example.companyofficialcar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleDao vehicleDao;

    @Autowired
    public VehicleServiceImpl(VehicleDao vehicledao) {
        this.vehicleDao = vehicledao;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleDao.save(vehicle);
    }

    @Override
    public void deleteVehicleById(Integer vehicleId) {
        vehicleDao.deleteById(vehicleId);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleDao.saveAndFlush(vehicle);
    }

    @Override
    public List<Vehicle> findVehiclesByFleetId(Integer fleetId) {
        return vehicleDao.findByFleetid(fleetId);
    }

    @Override
    public List<Vehicle> findVehiclesByVehicletype(String vehicletype) {
        return vehicleDao.findByVehicletype(vehicletype);
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleDao.findAll();
    }

    @Override
    public List<Object[]> getVehicleFleetid(int fleetid) {
        return vehicleDao.findFleetName(fleetid);
    }

    @Override
    public List<Object[]> getAllVehicleWithUserAndDriver() {
        return vehicleDao.findAllWithDriverAndUser();
    }

    @Override
    public Vehicle updateVehiclefleetid(int vehicleid, int fleetid) {
        vehicleDao.updateVehiclefleetid(vehicleid,fleetid);
        return null;
    }

    @Override
    public Vehicle updateVehicleType(int vehicleid, String vehicletype) {
        vehicleDao.updateVehicleType(vehicleid,vehicletype);
        return null;
    }
}
