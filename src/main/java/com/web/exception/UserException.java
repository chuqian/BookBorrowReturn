package com.web.exception;

/**
 * @Author chuqian
 * @Date created in 2019/1/28 21:36
 * @describe 用户信息异常
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1706513472529936756L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
