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
    public Fleet exchangeFleetName(String fleetname, int captainid) {
        Fleet fleet = fleetDao.findFleetByCaptainId(captainid);
        if (fleet != null) {
            fleet.setFleetname(fleetname);
            return fleetDao.save(fleet);
        }
        return null;
    }

    @Override
    public Fleet deleteFleet(int fleetid) {
        Fleet fleet = fleetDao.findFleetByCaptainId(fleetid);
        if (fleet != null) {
            fleetDao.deleteFleetByCaptainId(fleetid);
            return fleet;
        }
        return null;
    }

    @Override
    public Fleet insertFleet(Fleet fleet) {
        if (fleetDao.findFleetByCaptainId(fleet.getCaptainid()) == null) {
            return fleetDao.save(fleet);
        } else {
            return null;
        }
    }
}
