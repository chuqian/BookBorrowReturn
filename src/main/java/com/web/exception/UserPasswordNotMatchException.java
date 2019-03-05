package com.web.exception;

/**
 * @Author chuqian
 * @Date created in 2019/1/29 20:54
 * @describe 用户密码不正确或不符合规范异常类
 */
public class UserPasswordNotMatchException extends UserException {
    private static final long serialVersionUID = -4551106612014738648L;

    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
