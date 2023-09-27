package com.myblog.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class User {

    private Long userId;
    private String userName;
    private String password;
    private Date registrationDate;
    private String description;

    public User() {
    }

    public User(Long userId, String userName, String password, Date registrationDate, String description) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.registrationDate = registrationDate;
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", description='" + description + '\'' +
                '}';
    }
}
