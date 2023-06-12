package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.ApprovalRecord;
import com.example.companyofficialcar.domain.Fleet;

import java.util.List;

public interface FleetService {
    List<Object[]> getDriver();

    Fleet exchangeFleetID(int fleetid,int captainid);

    Fleet exchangeFleetName(String name,int fleetid);

    Fleet deleteFleet(int captainid);

    Fleet insertFleet(Fleet fleet);

    List<Fleet> getAllFleet();

    List<Object[]> getAllFleetAndUser();

    Fleet exchangename(int fleetid,String fleetname);
}
