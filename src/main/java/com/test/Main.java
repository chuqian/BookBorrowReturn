package com.test;

import com.entity.Administrator;
import com.entity.User;
import com.service.impl.LoginServiceImpl;

/**
 * @Author chuqian
 * @Date created in 2019/3/5 13:57
 * @describe
 */
public class Main {

    public static void main(String[] args) {
        User user = new LoginServiceImpl().login("", "");
        System.out.println(user != null);
    }
}
