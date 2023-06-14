package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.Fleet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FleetDao extends JpaRepository<Fleet, Integer> {

    @Query("SELECT u.userid, up.name, u.usertype, u.username " +
            "FROM User u JOIN Userprofile up ON u.userid = up.userid " +
            "JOIN Fleet f ON f.captainid = u.userid")
    List<Object[]> findCaptainDetails();

    @Query("SELECT u.userid, up.name, u.usertype, u.username " +
            "FROM User u JOIN Userprofile up ON u.userid = up.userid " +
            "JOIN Fleet f ON f.captainid = u.userid "+
            "WHERE f.fleetname = :fleetname")
    List<Object[]> findCaptainNameDetails(@Param("fleetname") String fleetname);


    @Query("SELECT f FROM Fleet f WHERE f.fleetid = :fleetid ")
    Fleet findFleetByFleetid(@Param("fleetid") int fleetid);

    @Modifying
    @Query("DELETE FROM Fleet f WHERE f.fleetid = :fleetid")
    void deleteFleetByCaptainId(@Param("fleetid") int fleetid);

    @Query("SELECT f.fleetname, f.fleetid, u.username FROM Fleet f JOIN User u ON f.captainid = u.userid")
    List<Object[]> findAllFleet();

    @Modifying
    @Transactional
    @Query("UPDATE Fleet f SET f.fleetname = :fleetname WHERE f.fleetid = :fleetid")
    void updateFleetName(@Param("fleetid") int fleetid, @Param("fleetname") String fleetname);

}
