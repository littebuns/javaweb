package com.xxb.dao;

import com.xxb.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {

    public User listUserByName(String name, Connection connection) throws SQLException;
}
