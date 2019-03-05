package com.web.exception;

/**
 * @Author chuqian
 * @Date created in 2019/1/28 21:38
 * @describe 验证码错误异常类
 */
public class CaptchaException extends UserException {
    private static final long serialVersionUID = 6302891671534249117L;

    public CaptchaException() {
        super("user.captcha.error", null);
    }
}
