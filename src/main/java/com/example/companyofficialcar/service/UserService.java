package com.example.companyofficialcar.service;

import com.example.companyofficialcar.domain.User;

public interface UserService {
    /*
    * 登录业务
    * userId 用户名
    * password 密码*/
    User loginService(int userid, String password);
    /*
    * 注册业务*/
    User registerService(User user);
}
