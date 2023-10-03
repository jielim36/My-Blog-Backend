package com.myblog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FollowMapper {

    Long getUserFollowerNumber(@Param("userId")Long userId);

    Long getUserFollowingNumber(@Param("userId")Long userId);

}
