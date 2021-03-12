package com.xxb.service;

import com.xxb.entity.Result;

public interface UserService {

    Result checkUser(String name, String password);
}
