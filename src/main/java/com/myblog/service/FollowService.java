package com.myblog.service;

import com.myblog.mapper.FollowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FollowService {

    private final FollowMapper followMapper;
    private final ArticlesService articlesService;

    @Autowired
    public FollowService(FollowMapper followMapper, ArticlesService articlesService) {
        this.followMapper = followMapper;
        this.articlesService = articlesService;
    }



    public Map<String,Long> getUserFollowStat(Long userId){
        Map<String, Long> userFollowStat = new HashMap<>();
        Long followingNumber = followMapper.getUserFollowingNumber(userId);
        Long followerNumber = followMapper.getUserFollowerNumber(userId);
        Long articlesNumber = articlesService.getTotalNumberOfArticlesByAuthor(userId);
        userFollowStat.put("following",followingNumber);
        userFollowStat.put("follower",followerNumber);
        userFollowStat.put("articles",articlesNumber);
        return userFollowStat;
    }

}
