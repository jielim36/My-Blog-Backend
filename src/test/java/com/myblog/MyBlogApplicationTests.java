package com.myblog;

import com.myblog.bean.User;
import com.myblog.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBlogApplicationTests {

    @Autowired
    private UserService userService;


    @Test
    void contextLoads() {
    }

    @Test
    public void testDatabase(){
        User userByEmail = userService.getUserByEmail("jielim00@gmail.com");
        System.out.println(userByEmail);
    }

}
