package com.example.companyofficialcar.service.serviceImpl;

import com.example.companyofficialcar.domain.User;
import com.example.companyofficialcar.repository.UserDao;
import com.example.companyofficialcar.service.UserService;
import com.example.companyofficialcar.util.EncryptionUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginService(int userid, String password) throws Exception {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userDao.findByUseridAndPassword(userid, EncryptionUtils.encrypt(password));
        // 重要信息置空
        if(user != null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registerService(User user) throws Exception {
        //当新用户的用户名已存在时
        if(userDao.findByUserid(user.getUserid())!=null){
            // 无法注册
            return null;
        }else{
            // 对密码进行加密
            user.setPassword(EncryptionUtils.encrypt(user.getPassword()));
            //返回创建好的用户对象(带uid)
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }

    @Override
    public Integer countUser() {
        return userDao.countUser();
    }

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(int userid) {
        return userDao.findByUserid(userid);
    }
}