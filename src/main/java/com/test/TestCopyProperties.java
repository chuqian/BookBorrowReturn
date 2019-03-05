package com.test;

import com.entity.Book;
import com.entity.User;
import org.springframework.beans.BeanUtils;

/**
 * @Author chuqian
 * @Date created in 2019/1/27 10:23
 * @describe
 */
public class TestCopyProperties {

    public static void main(String[] args) {
        User user = new User();
        Book book = new Book();

        user.setDel(1);
        System.out.println(book.getDel());
        BeanUtils.copyProperties(user, book);
        System.out.println(book.getDel());
    }
}
