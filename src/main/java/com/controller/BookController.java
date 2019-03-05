package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author chuqian
 * @Date created in 2019/1/20 10:04
 * @describe
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "aaaaa";
    }

    @RequestMapping("add")
    public String add(){
        return "";
    }


}
