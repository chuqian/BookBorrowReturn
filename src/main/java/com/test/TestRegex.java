package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author chuqian
 * @Date created in 2019/1/27 9:29
 * @describe
 */
public class TestRegex {

    public static void main(String[] args) {
        String string = "getName";
        Pattern pattern = Pattern.compile("get(\\p{Upper}\\w?)");
        Matcher matcher = pattern.matcher(string);
        System.out.println(matcher.find());
        System.out.println(matcher.group());
    }
}
