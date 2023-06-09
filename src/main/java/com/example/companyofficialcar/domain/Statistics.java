package com.example.companyofficialcar.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @Column(name = "statisticsid")
    private Integer statisticsId;

    @Column(name = "fleetid")
    private Integer fleetId;

    @Column(name = "driverid")
    private Integer driverId;

    @Column(name = "month")
    private Integer month;

    @Column(name = "trips")
    private Integer trips;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fleetid", insertable = false, updatable = false)
    private Fleet fleet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driverid", insertable = false, updatable = false)
    private Driver driver;

    public Integer getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(Integer statisticsId) {
        this.statisticsId = statisticsId;
    }

    public Integer getFleetId() {
        return fleetId;
    }

    public void setFleetId(Integer fleetId) {
        this.fleetId = fleetId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getTrips() {
        return trips;
    }

    public void setTrips(Integer trips) {
        this.trips = trips;
    }

    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
