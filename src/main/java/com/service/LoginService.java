package com.service;

import com.entity.User;

/**
 * @Author chuqian
 * @Date created in 2019/1/27 11:28
 * @describe 登录接口
 */
public interface LoginService {

    public User login(String username, String password);
}
