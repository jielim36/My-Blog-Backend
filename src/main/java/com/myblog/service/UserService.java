package com.myblog.service;

import com.myblog.bean.User;
import com.myblog.config.JwtUtils;
import com.myblog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserService(UserMapper userMapper, JwtUtils jwtUtils) {
        this.userMapper = userMapper;
        this.jwtUtils = jwtUtils;
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

    public User getUserByEmail(String email){
        return userMapper.getUserByEmail(email);
    }

    public User getUserByToken(String token){
        String jwt = token.substring(7);//remove the first 7 words: token = "bearer <token>" <- cut bearer and space
        String email = jwtUtils.extractUsername(jwt);//here is convert jwt token into email
        return userMapper.getUserByEmail(email);
    }

}
