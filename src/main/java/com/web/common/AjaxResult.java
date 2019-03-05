package com.web.common;

import java.util.HashMap;

/**
 * @Author chuqian
 * @Date created in 2019/1/22 22:27
 * @describe 操作消息提醒
 */
public class AjaxResult extends HashMap<String, Object> {

    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功消息
     * @param msg 成功消息
     * @return AjaxResult
     */
    public static AjaxResult success(String msg) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("code", "200");
        ajaxResult.put("msg", msg);
        return ajaxResult;
    }

    public static AjaxResult error() {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     * @param msg 错误消息
     * @return AjaxResult
     */
    public static AjaxResult error(String msg) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("code", "500");
        ajaxResult.put("msg", msg);
        return  ajaxResult;
    }
}
