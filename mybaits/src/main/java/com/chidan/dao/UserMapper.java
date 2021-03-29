package com.chidan.dao;

import com.chidan.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> listAll();

    int addUser(User user);

    int updateName(Map<String, Object> map);

    List<User> listByName(String name);
}
