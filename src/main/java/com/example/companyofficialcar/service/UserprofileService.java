package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.Userprofile;

import java.util.List;

public interface UserprofileService {
    /*查询个人信息操作*/
    List<Object[]> getUserProfileDetails();
    List<Object[]> getUserProfileDetailsCar();
    List<Object[]> getUserProfileDetailsDriver();
    List<Object[]> getUserProfileDetailsDriverCap();
    List<Object[]> getUserProfileDetailsStaff();
    List<Object[]> getUserProfileDetailsLeader();
    List<Object[]> findUserprofileByName(String username);
    List<Object[]> findUserprofileByUserid(int userid);


    Userprofile exchange(int userid,String username,String avatar);
    Userprofile exchangeUsername(int userid,String username);
    Userprofile exchangename(int userid,String name);
    Userprofile exchangeAvatar(int userid,String avatar);
    Userprofile exchangePassword(int userid,String password);
    Userprofile exchangeUsertype(int userid,String usertype);

}
