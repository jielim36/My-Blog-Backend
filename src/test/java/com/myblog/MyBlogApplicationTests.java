package com.myblog;

import com.myblog.bean.User;
import com.myblog.config.JwtUtils;
import com.myblog.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBlogApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;


    @Test
    void contextLoads() {
    }

    @Test
    public void testDatabase(){
        User userByEmail = userService.getUserByEmail("jielim00@gmail.com");
        System.out.println(userByEmail);
    }

    @Test
    public void jwtTokenConvert(){
        String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqaWVsaW0wMEBnbWFpbC5jb20iLCJleHAiOjE2OTYxODAzMDIsImlhdCI6MTY5NjE0NDMwMn0.eIXfhREVrmz3koW_5rix2Ha6XVSi71l5ViHCO4wdbaY";
        String newToken = token.substring(7);
        System.out.println(newToken);
        System.out.println(jwtUtils.extractUsername(newToken));
    }

}
