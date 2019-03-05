package com.web.exception;

/**
 * @Author chuqian
 * @Date created in 2019/1/29 21:23
 * @describe
 */
public class UserBlockedException extends UserException {
    private static final long serialVersionUID = -285489265561663963L;

    public UserBlockedException(String reason) {
        super("user.blocked", new Object[]{reason});
    }
}
