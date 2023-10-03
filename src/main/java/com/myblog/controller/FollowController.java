package com.myblog.controller;

import com.myblog.bean.Follow;
import com.myblog.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/follow")
@RestController
public class FollowController {

    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @GetMapping("/stat/{userId}")
    public Map<String,Long> getUserFollowStat(@PathVariable("userId")Long userId){
        return followService.getUserFollowStat(userId);
    }

}
