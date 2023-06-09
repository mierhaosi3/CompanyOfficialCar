package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.Userprofile;
import com.example.companyofficialcar.service.UserprofileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserprofileController {
    private final UserprofileService userprofileService;

    public UserprofileController(UserprofileService userprofileService) {
        this.userprofileService = userprofileService;
    }

    @GetMapping("/profile")
    public List<Object[]> getUserProfileDetails() {
        return userprofileService.getUserProfileDetails();
    }
    @GetMapping("/profileCar")
    public List<Object[]> getUserProfileDetailsCar() {
        return userprofileService.getUserProfileDetailsCar();
    }
    @GetMapping("/profileDriver")
    public List<Object[]> getUserProfileDetailsDriver() {
        return userprofileService.getUserProfileDetailsDriver();
    }
    @GetMapping("/profileDriverCap")
    public List<Object[]> getUserProfileDetailsDriverCap() {
        return userprofileService.getUserProfileDetailsDriverCap();
    }
    @GetMapping("/profileStaff")
    public List<Object[]> getUserProfileDetailsStaff() {
        return userprofileService.getUserProfileDetailsStaff();
    }
    @GetMapping("/profileLeader")
    public List<Object[]> getUserProfileDetailsLeader() {
        return userprofileService.getUserProfileDetailsLeader();
    }

    @PostMapping("/{userid}/exchange")
    public Userprofile exchangeUserProfile(@PathVariable int userid,@RequestBody String avatar,@RequestBody String name) {
        return userprofileService.exchange(userid,avatar,name);
    }
    @PostMapping("/{userid}/avatar")
    public ResponseEntity<String> updateAvatar(@PathVariable int userid, @RequestBody String avatar) {
        userprofileService.exchangeAvatar(userid, avatar);
        return ResponseEntity.ok("头像更新成功");
    }
    @PostMapping("/{userid}/name")
    public ResponseEntity<String> updatename(@PathVariable int userid, @RequestBody String name) {
        userprofileService.exchangename(userid, name);
        return ResponseEntity.ok("名称更新成功");
    }
    @PostMapping("/{userid}/username")
    public ResponseEntity<String> updateUsername(@PathVariable int userid, @RequestBody String username) {
        userprofileService.exchangeUsername(userid, username);
        return ResponseEntity.ok("用户名更新成功");
    }
    @PostMapping("/{userid}/password")
    public ResponseEntity<String> updatePassword(@PathVariable int userid, @RequestBody String password) {
        userprofileService.exchangePassword(userid, password);
        return ResponseEntity.ok("密码更新成功");
    }
    @PostMapping("/{userid}/usertype")
    public ResponseEntity<String> updateUsertype(@PathVariable int userid, @RequestBody String usertype) {
        userprofileService.exchangeUsertype(userid, usertype);
        return ResponseEntity.ok("用户类型更新成功");
    }
}
