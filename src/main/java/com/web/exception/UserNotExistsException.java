package com.web.exception;

/**
 * @Author chuqian
 * @Date created in 2019/1/28 22:17
 * @describe 用户不存在异常类
 */
public class UserNotExistsException extends UserException {
    private static final long serialVersionUID = -5127374056444192687L;

    public UserNotExistsException(String code, Object[] args) {
        super("user.not.exists", null);
    }
}
