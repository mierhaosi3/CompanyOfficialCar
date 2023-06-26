package com.example.companyofficialcar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.companyofficialcar.domain.User;
import com.example.companyofficialcar.service.UserService;
import com.example.companyofficialcar.util.EncryptionUtils;
import com.example.companyofficialcar.util.Result;
import com.example.companyofficialcar.util.Token;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<User> loginController(@RequestParam int userid, @RequestParam String password, HttpServletResponse response){
        try {
            password = EncryptionUtils.encrypt(password);
            User user = userService.loginService(userid, password);
            JSONObject jsonObject = new JSONObject();
            if(user!=null){
                String token = Token.sign(user);
                response.setHeader("token", token);
                jsonObject.put("token",token);
                System.out.println(token);
                return Result.success(user,"登录成功！");
            }else{
                return Result.error("123","账号或密码错误！");
            }
        } catch (Exception e) {
            return Result.error("789","加密错误！");
        }
    }

    @PostMapping("/register")
    public Result<User> registerService(@RequestBody User newUser){
        try {
            newUser.setPassword(EncryptionUtils.encrypt(newUser.getPassword()));
            User user = userService.registerService(newUser);
            if(user!=null){
                return Result.success(user,"注册成功！");
            }else{
                return Result.error("456","用户名已存在！");
            }
        } catch (Exception e) {
            return Result.error("789","加密错误！");
        }
    }

    @GetMapping("/findUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/ByID")
    public User getUserByID(@RequestParam int userid) {
        User user = userService.getUserById(userid);
        return user;
    }
    @GetMapping("/count")
    public ResponseEntity<Map<String, Integer>> getCarRequestCount() {
        Integer count = userService.countUser();
        Map<String, Integer> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }
}