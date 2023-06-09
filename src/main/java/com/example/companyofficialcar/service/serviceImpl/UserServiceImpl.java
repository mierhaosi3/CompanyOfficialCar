package com.example.companyofficialcar.service.serviceImpl;

import com.example.companyofficialcar.domain.User;
import com.example.companyofficialcar.repository.UserDao;
import com.example.companyofficialcar.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginService(int userid, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userDao.findByUseridAndPassword(userid, password);
        // 重要信息置空
        if(user != null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registerService(User user) {
        //当新用户的用户名已存在时
        if(userDao.findByUserid(user.getUserid())!=null){
            // 无法注册
            return null;
        }else{
            //返回创建好的用户对象(带uid)
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }
}