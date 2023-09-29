package com.myblog.mapper;

import com.myblog.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User getUserByUsernameAndPassword(@Param("username")String username , @Param("password")String password);

    Integer insertLoginHistory(@Param("userId")Long userId);

    User getUserByEmail(@Param("email")String email);



}
