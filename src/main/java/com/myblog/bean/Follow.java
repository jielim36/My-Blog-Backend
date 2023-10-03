package com.myblog.bean;

import java.util.Date;

public class Follow {

    private Long id;
    private Long userId;
    private Long follower;
    private Date followDate;

    public Follow() {
    }

    public Follow(Long id, Long userId, Long follower, Date followDate) {
        this.id = id;
        this.userId = userId;
        this.follower = follower;
        this.followDate = followDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFollower() {
        return follower;
    }

    public void setFollower(Long follower) {
        this.follower = follower;
    }

    public Date getFollowDate() {
        return followDate;
    }

    public void setFollowDate(Date followDate) {
        this.followDate = followDate;
    }

}
