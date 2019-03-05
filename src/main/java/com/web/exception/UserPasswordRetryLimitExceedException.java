package com.web.exception;

import com.web.exception.UserException;

/**
 * @Author chuqian
 * @Date created in 2019/1/29 20:58
 * @describe 用户错误最大次数异常类
 */
public class UserPasswordRetryLimitExceedException extends UserException {
    private static final long serialVersionUID = 1128782100934845131L;

    public UserPasswordRetryLimitExceedException(int retryLimitCount) {
        super("user.password.retry.limit.exceed", new Object[]{retryLimitCount});
    }
}
