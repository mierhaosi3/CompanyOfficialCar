package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.Userprofile;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserprofileDao extends JpaRepository<Userprofile,Integer> {
    @Query("SELECT u.userid, u.username, u.usertype, up.name, up.avatar " +
            "FROM User u JOIN Userprofile up ON u.userid = up.userid")
    List<Object[]> getUserProfileDetails();
    Userprofile findByUserid(int userid);

    @Query("SELECT u.userid, u.username, u.usertype, up.name, up.avatar " +
            "FROM User u JOIN Userprofile up ON u.userid = up.userid " +
            "WHERE u.usertype = '司机' OR u.usertype = '车队队长'")
    List<Object[]> getUserProfileDetailsCar();

    @Query("SELECT u.userid, u.username, u.usertype, up.name, up.avatar " +
            "FROM User u JOIN Userprofile up ON u.userid = up.userid " +
            "WHERE u.usertype = '司机'")
    List<Object[]> getUserProfileDetailsDriver();

    @Query("SELECT u.userid, u.username, u.usertype, up.name, up.avatar " +
            "FROM User u JOIN Userprofile up ON u.userid = up.userid " +
            "WHERE u.usertype = '车队队长'")
    List<Object[]> getUserProfileDetailsDriverCap();

    @Query("SELECT u.userid, u.username, u.usertype, up.name, up.avatar " +
            "FROM User u JOIN Userprofile up ON u.userid = up.userid " +
            "WHERE u.usertype = '员工'")
    List<Object[]> getUserProfileDetailsStaff();

    @Query("SELECT u.userid, u.username, u.usertype, up.name, up.avatar " +
            "FROM User u JOIN Userprofile up ON u.userid = up.userid " +
            "WHERE u.usertype = '领导'")
    List<Object[]> getUserProfileDetailsLeader();

    @Query("SELECT u.userid, u.username, u.usertype, up.name, up.avatar " +
            "FROM User u JOIN Userprofile up ON u.userid = up.userid " +
            "WHERE u.username = :username")
    List<Object[]> getUserprofileByName(@Param("username") String username);

    @Query("SELECT u.userid, u.username, u.usertype, up.name, up.avatar ,u.password " +
            "FROM User u JOIN Userprofile up ON u.userid = up.userid " +
            "WHERE u.userid = :userid")
    List<Object[]> getUserprofileByUserid(@Param("userid") int userid);

    @Modifying
    @Transactional
    @Query("UPDATE Userprofile up SET up.avatar = :avatar WHERE up.user.userid = :userid")
    void updateAvatar(@Param("userid") int userid, @Param("avatar") String avatar);

    @Modifying
    @Transactional
    @Query("UPDATE Userprofile up SET up.name = :name WHERE up.user.userid = :userid")
    void updatename(@Param("userid") int userid, @Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.username = :username WHERE u.userid = :userid")
    void updateUsername(@Param("userid") int userid, @Param("username") String username);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = :password WHERE u.userid = :userid")
    void updatePassword(@Param("userid") int userid, @Param("password") String password);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.usertype = :usertype WHERE u.userid = :userid")
    void updateUsertype(@Param("userid") int userid, @Param("usertype") String usertype);
}
