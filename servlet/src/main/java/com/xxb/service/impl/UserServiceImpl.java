package com.xxb.service.impl;

import com.xxb.dao.BaseDao;
import com.xxb.dao.UserDao;
import com.xxb.dao.impl.UserDaoImpl;
import com.xxb.entity.Result;
import com.xxb.entity.User;
import com.xxb.service.UserService;

import java.sql.Connection;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public Result checkUser(String name, String password) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.listUserByName(name, connection);
        }catch (Exception e){
            System.out.println(e);
            return new Result(false, e + "");
        }finally {
            BaseDao.close(connection, null, null);
        }
        //存在该用户且密码正确
        if (user != null && user.getPassword().equals(password)){
            return new Result(true, "登录成功", user);
        }else{
            return new Result(false, "error");
        }
    }

}
