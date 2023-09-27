package com.myblog.service;

import com.myblog.bean.User;
import com.myblog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User verifyUserLogin(User user){
        User userResult = userMapper.getUserByUsernameAndPassword(user.getUserName(), user.getPassword());
        if (userResult == null) return null;//cant find user -> login fail
        Integer affectedRow = insertLoginHistory(userResult.getUserId());
        if (affectedRow == 0) return null;//insert login history fail

        return userResult;
    }

    public Integer insertLoginHistory(Long userId){
        return userMapper.insertLoginHistory(userId);
    }
}
