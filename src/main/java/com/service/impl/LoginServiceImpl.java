package com.service.impl;

import com.entity.Administrator;
import com.entity.User;
import com.mapper.UserMapper;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chuqian
 * @Date created in 2019/1/29 22:02
 * @describe
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        /**
         * 校验码校验
         */

        User user = userMapper.findByUsernameAndPassword("admin", "admin123");
        return user;
    }
}