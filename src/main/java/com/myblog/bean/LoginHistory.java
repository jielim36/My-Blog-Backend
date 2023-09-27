package com.myblog.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class LoginHistory {

    private Long userId;
    private Date loginDate;

    public LoginHistory() {
    }

    public LoginHistory(Long userId, Date loginDate) {
        this.userId = userId;
        this.loginDate = loginDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "LoginHistory{" +
                "userId=" + userId +
                ", loginDate=" + loginDate +
                '}';
    }
}
