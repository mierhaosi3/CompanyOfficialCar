package com.example.companyofficialcar.service.serviceImpl;

import com.example.companyofficialcar.domain.User;
import com.example.companyofficialcar.domain.Userprofile;
import com.example.companyofficialcar.repository.UserDao;
import com.example.companyofficialcar.repository.UserprofileDao;
import com.example.companyofficialcar.service.UserprofileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserprofileServiceImpl implements UserprofileService {
    private final UserprofileDao userprofileDao;

    public UserprofileServiceImpl(UserprofileDao userprofileDao) {
        this.userprofileDao = userprofileDao;
    }

    @Override
    public List<Object[]> getUserProfileDetails() {
        return userprofileDao.getUserProfileDetails();
    }

    @Override
    public List<Object[]> getUserProfileDetailsCar() {
        return userprofileDao.getUserProfileDetailsCar();
    }

    @Override
    public List<Object[]> getUserProfileDetailsDriver() {
        return userprofileDao.getUserProfileDetailsDriver();
    }

    @Override
    public List<Object[]> getUserProfileDetailsDriverCap() {
        return userprofileDao.getUserProfileDetailsDriverCap();
    }

    @Override
    public List<Object[]> getUserProfileDetailsStaff() {
        return userprofileDao.getUserProfileDetailsStaff();

    }

    @Override
    public List<Object[]> getUserProfileDetailsLeader() {
        return userprofileDao.getUserProfileDetailsLeader();
    }


    @Override
    public Userprofile exchange(int userid,String name,String avatar) {
        Userprofile userprofile = userprofileDao.findByUserid(userid);
        if (userprofile != null) {
            // 修改个人信息
            userprofile.setName(name);
            userprofile.setAvatar(avatar);

            // 保存修改后的个人信息
            userprofileDao.save(userprofile);
            UserDao userDao = null;
            // 如果还需要更新User表中的相关字段，可以使用以下方法
            User user = userDao.findById(userid).orElse(null);
            if (user != null) {
                user.setUsername("新的用户名");
                user.setPassword("新的密码");
                user.setUsertype("新的用户类型");
                userDao.save(user);
            }
        }
        return userprofile;
    }

    @Override
    public Userprofile exchangeUsername(int userid, String username) {
        userprofileDao.updateAvatar(userid, username);
        return null;
    }

    @Override
    public Userprofile exchangename(int userid, String name) {
        userprofileDao.updatename(userid, name);
        return null;
    }

    @Override
    public Userprofile exchangeAvatar(int userid, String avatar) {
        userprofileDao.updateUsername(userid, avatar);
        return null;
    }

    @Override
    public Userprofile exchangePassword(int userid, String password) {
        userprofileDao.updatePassword(userid,password);
        return null;
    }

    @Override
    public Userprofile exchangeUsertype(int userid, String usertype) {
        userprofileDao.updateUsertype(userid,usertype);
        return null;
    }


}
