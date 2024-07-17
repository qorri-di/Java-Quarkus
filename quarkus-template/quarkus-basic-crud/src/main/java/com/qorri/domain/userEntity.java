package com.qorri.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "ms_user", schema = "public")
public class userEntity extends PanacheEntityBase{
    @Id
    @Column(name = "id_user")
    private Integer userId;

    @Column(name = "name_user")
    private String userName;

    @Column(name = "gender_user")
    private String userGender;

    @Column(name = "country_user")
    private String userCountry;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }
}
