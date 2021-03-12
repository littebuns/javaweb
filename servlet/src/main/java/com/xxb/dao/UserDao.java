package com.xxb.dao;

import com.xxb.entity.User;

import java.sql.Connection;

public interface UserDao {

    public User listUserByName(String name, Connection connection);
}
