package com.xxb.dao.impl;

import com.xxb.dao.BaseDao;
import com.xxb.dao.UserDao;
import com.xxb.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    /**
     * 根据名称返回用户
     * @param name
     * @param connection
     * @return
     */
    @Override
    public User listUserByName(String name, Connection connection) {
        User user = new User();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from user where name = ?";
        Object[] params = {name};
        try {
            rs = BaseDao.execute(connection, sql, params, preparedStatement, rs);
            if (rs.next()){
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String uuid = rs.getString(4);
                user.setName(username);
                user.setPassword(password);
                user.setUuid(uuid);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

}
