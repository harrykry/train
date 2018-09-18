package com.harry.service;

import com.harry.pojo.UserInfo;

/**
 * @program: train
 * @description:
 * @author: Harry
 * @create: 2018-09-11 18:46
 **/

public interface UserService {
    public String findUserByNameAndPassword(String name, String password);

    public String insertUser(UserInfo userInfo);
}
