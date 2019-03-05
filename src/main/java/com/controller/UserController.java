package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author chuqian
 * @Date created in 2019/1/20 10:04
 * @describe
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "aaaaa";
    }

    @RequestMapping("add")
    public String add(){
        return "";
    }


}
