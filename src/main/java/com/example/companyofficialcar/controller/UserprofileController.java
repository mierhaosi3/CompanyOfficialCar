package com.example.companyofficialcar.controller;

import com.example.companyofficialcar.domain.Userprofile;
import com.example.companyofficialcar.service.UserprofileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/user")
public class UserprofileController {
    private final UserprofileService userprofileService;

    public UserprofileController(UserprofileService userprofileService) {
        this.userprofileService = userprofileService;////////////////////////////////////////////////////////////                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

    @GetMapping("/profileName")
    public List<Object[]> findUserprofileByName(@RequestParam("username") String username) {
        System.out.println(username);
        return userprofileService.findUserprofileByName(username);
    }

    @GetMapping("/profileUserid")
    public List<Object[]> findUserprofileByName(@RequestParam("userid") int userid) {
        System.out.println(userid);
        return userprofileService.findUserprofileByUserid(userid);
    }


    @PostMapping("/{userid}/exchange")
    public Userprofile exchangeUserProfile(@PathVariable int userid,@RequestBody String avatar,@RequestBody String name) {
        return userprofileService.exchange(userid,avatar,name);
    }
    @PostMapping("/{userid}/username")
    public ResponseEntity<String> updateAvatar(@PathVariable int userid, @RequestBody String username) throws UnsupportedEncodingException{
        String decodedusername = URLDecoder.decode(username, "UTF-8");
        decodedusername = decodedusername.trim(); // 去除字符串末尾的空格和等号

        // 使用正则表达式匹配并移除末尾的等号
        Pattern pattern = Pattern.compile("(.*?)=$");
        Matcher matcher = pattern.matcher(decodedusername);
        if (matcher.find()) {
            decodedusername = matcher.group(1);
        }
        System.out.println(decodedusername);
        userprofileService.exchangeAvatar(userid, decodedusername);
        return ResponseEntity.ok("username更新成功");
    }
    @PostMapping("/{userid}/name")
    public ResponseEntity<String> updatename(@PathVariable int userid, @RequestBody String name) throws UnsupportedEncodingException{
        String decodedname = URLDecoder.decode(name, "UTF-8");
        decodedname = decodedname.trim(); // 去除字符串末尾的空格和等号

        // 使用正则表达式匹配并移除末尾的等号
        Pattern pattern = Pattern.compile("(.*?)=$");
        Matcher matcher = pattern.matcher(decodedname);
        if (matcher.find()) {
            decodedname = matcher.group(1);
        }
        System.out.println(decodedname);
        userprofileService.exchangename(userid, decodedname);
        return ResponseEntity.ok("名称更新成功");
    }
    @PostMapping("/{userid}/avatar")
    public ResponseEntity<String> updateUsername(@PathVariable int userid, @RequestBody String avatar) throws UnsupportedEncodingException {
        String decodedavatar = URLDecoder.decode(avatar, "UTF-8");
        decodedavatar = decodedavatar.trim(); // 去除字符串末尾的空格和等号

        // 使用正则表达式匹配并移除末尾的等号
        Pattern pattern = Pattern.compile("(.*?)=$");
        Matcher matcher = pattern.matcher(decodedavatar);
        if (matcher.find()) {
            decodedavatar = matcher.group(1);
        }

        System.out.println(decodedavatar);
        System.out.println(userid);
        userprofileService.exchangeUsername(userid, decodedavatar);
        return ResponseEntity.ok("用户名更新成功");
    }
    @PostMapping("/{userid}/password")
    public ResponseEntity<String> updatePassword(@PathVariable int userid, @RequestBody String password) throws UnsupportedEncodingException {
        String decodedavatar = URLDecoder.decode(password, "UTF-8");
        decodedavatar = decodedavatar.trim(); // 去除字符串末尾的空格和等号

        // 使用正则表达式匹配并移除末尾的等号
        Pattern pattern = Pattern.compile("(.*?)=$");
        Matcher matcher = pattern.matcher(decodedavatar);
        if (matcher.find()) {
            decodedavatar = matcher.group(1);
        }

        System.out.println(decodedavatar);
        System.out.println(userid);
        userprofileService.exchangePassword(userid, decodedavatar);
        return ResponseEntity.ok("密码更新成功");
    }
    @PostMapping("/{userid}/usertype")
    public ResponseEntity<String> updateUsertype(@PathVariable int userid, @RequestBody String usertype) {
        userprofileService.exchangeUsertype(userid, usertype);
        return ResponseEntity.ok("用户类型更新成功");
    }
}
