package com.example.companyofficialcar.service.serviceImpl;

import com.example.companyofficialcar.domain.Fleet;
import com.example.companyofficialcar.repository.FleetDao;
import com.example.companyofficialcar.service.FleetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FleetServiceImpl implements FleetService {
    private final FleetDao fleetDao;

    public FleetServiceImpl(FleetDao fleetDao) {
        this.fleetDao = fleetDao;
    }

    @Override
    public List<Object[]> getDriver() {
        return fleetDao.findCaptainDetails();
    }

    @Override
    public Fleet exchangeFleetID(int fleetid, int captainid) {
        Fleet fleet = fleetDao.findById(captainid).orElse(null);
        if (fleet != null) {
            fleet.setCaptainid(fleetid);
            return fleetDao.save(fleet);
        }
        return null;
    }

    @Override
    public Fleet exchangeFleetName(String fleetname, int fleetid) {
        Fleet fleet = fleetDao.findFleetByFleetid(fleetid);
        System.out.println(fleetname);
        System.out.println(fleetid);
        if (fleet != null) {
            fleet.setFleetname(fleetname);
            System.out.println(fleetname);
            System.out.println(fleetid);
            return fleetDao.save(fleet);
        }
        return null;
    }

    @Override
    public Fleet deleteFleet(int fleetid) {
        Fleet fleet = fleetDao.findFleetByFleetid(fleetid);
        if (fleet != null) {
            fleetDao.deleteFleetByCaptainId(fleetid);
            return fleet;
        }
        return null;
    }

    @Override
    public Fleet insertFleet(Fleet fleet) {
        if (fleetDao.findFleetByFleetid(fleet.getCaptainid()) == null) {
            return fleetDao.save(fleet);
        } else {
            return null;
        }
    }

    @Override
    public List<Fleet> getAllFleet() {
        return fleetDao.findAll();
    }

    @Override
    public List<Object[]> getAllFleetAndUser() {
        return fleetDao.findAllFleet();
    }

    @Override
    public List<Object[]> getCaptainNameDetails(String fleetname) {
        return fleetDao.findCaptainNameDetails(fleetname);
    }

    @Override
    public Fleet exchangename(int fleetid, String fleetname) {
        fleetDao.updateFleetName(fleetid,fleetname);
        return null;
    }
}
