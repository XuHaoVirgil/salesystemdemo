package com.netease.salesystem.dao;

import com.netease.salesystem.pojo.User;

public interface UserDao {

    public User findUserByName(String username);

}