package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findByUserid(int userid); //通过用户名userID查找用户，
    User findByUseridAndPassword(int userid, String password);
}
