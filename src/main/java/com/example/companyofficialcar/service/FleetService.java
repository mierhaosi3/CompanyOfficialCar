package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.Fleet;

import java.util.List;

public interface FleetService {
    List<Object[]> getDriver();

    Fleet exchangeFleetID(int fleetid,int captainid);
    Fleet exchangeFleetName(String name,int captainid);

    Fleet deleteFleet(int captainid);
    Fleet insertFleet(Fleet fleet);


}
