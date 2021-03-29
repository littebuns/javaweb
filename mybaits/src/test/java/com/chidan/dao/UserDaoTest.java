package com.chidan.dao;

import com.chidan.entity.User;
import com.chidan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.listAll();
        for (User user : users) {
            System.out.println(user.getEmail());
        }
        sqlSession.close();
    }

    @Test
    public void insert(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("mybatis");
        user.setEmail("mybatis@163.com");
        int i = mapper.addUser(user);
        System.out.println(i);
        sqlSession.commit();
    }

    @Test
    public void update(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 6);
        map.put("name", "test");
        int i = mapper.updateName(map);
        System.out.println(i);
        sqlSession.commit();
    }

    @Test
    public void selectLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.listByName("科");
        for (User user : users) {
            System.out.println(user.getName());
        }

    }

}
