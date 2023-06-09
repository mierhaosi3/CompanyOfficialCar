package com.example.companyofficialcar.domain;

import jakarta.persistence.*;

@Table(name = "vehicle")
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleid;
    private String vehicletype;
    private int fleetid;

    public int getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    public int getFleetid() {
        return fleetid;
    }

    public void setFleetid(int fleetid) {
        this.fleetid = fleetid;
    }
}
