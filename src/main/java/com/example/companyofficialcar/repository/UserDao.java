package com.example.companyofficialcar.repository;

import com.example.companyofficialcar.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findByUserid(int userid); //通过用户名userID查找用户，
    User findByUseridAndPassword(int userid, String password);

    @Query("SELECT COUNT(u) FROM User u")
    Integer countUser();
}
