package com.example.companyofficialcar.domain;

import jakarta.persistence.*;

@Table(name = "userprofile")
@Entity
public class Userprofile {
    @Id
    private int userid;
    private String name;
    private String avatar;

    /*声明外键*/
    @OneToOne
    @MapsId
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private User user;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
