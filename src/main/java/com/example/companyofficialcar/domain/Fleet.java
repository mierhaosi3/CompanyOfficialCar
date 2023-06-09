package com.example.companyofficialcar.domain;

import jakarta.persistence.*;

@Table(name = "fleet")
@Entity
public class Fleet {
    @Id
    @Column(name = "fleetid")
    private int fleetid;
    @Column(name = "fleetname")
    private String fleetname;

    @Column(name = "captainid")
    private int captainid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "captainid", insertable = false, updatable = false)
    private User captain;

    public int getFleetid() {
        return fleetid;
    }

    public void setFleetid(int fleetid) {
        this.fleetid = fleetid;
    }

    public String getFleetname() {
        return fleetname;
    }

    public void setFleetname(String fleetname) {
        this.fleetname = fleetname;
    }

    public int getCaptainid() {
        return captainid;
    }

    public void setCaptainid(int captainid) {
        this.captainid = captainid;
    }
}
