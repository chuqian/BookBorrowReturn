package com.web.exception;

/**
 * @Author chuqian
 * @Date created in 2019/1/28 21:34
 * @describe
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -2173751521375678900L;

    private String module;  //所属模块

    private String code;  //错误码

    private Object[] args;  //误码对应的参数

    private String defaultMessage;  //错误消息

    public BaseException() {

    }

    public BaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String module, String code, Object[] args) {
        this(module, code, args, null);
    }


}
