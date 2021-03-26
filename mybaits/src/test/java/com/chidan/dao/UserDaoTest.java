package com.chidan.dao;

import com.chidan.entity.User;
import com.chidan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> users = mapper.listAll();
        for (User user : users) {
            System.out.println(user.getName());
        }
        sqlSession.close();
    }

}
