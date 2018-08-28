package com.ctcc.xfxt2.dao;

import com.ctcc.xfxt2.entity.User;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int insert(User record);

    List<User> selectAll();

    List<User> selectUser(@Param(value = "login_name") String login_name, @Param(value = "password") String password);

    List<User> selectUserByAccount(@Param("login_name") String login_name);

    int updatePassword(@Param("login_name") String login_name, @Param("password") String password);

}