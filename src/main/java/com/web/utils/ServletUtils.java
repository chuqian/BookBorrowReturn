package com.web.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author chuqian
 * @Date created in 2019/1/22 21:35
 * @describe 客户端工具类
 */
public class ServletUtils {

    /**
     * 获取request
     */
    public static HttpServletRequest getRequest() {
        return getServletRequestAttributes().getRequest();
    }

    /**
     * 获取response
     */
    public static HttpServletResponse getResponse() {
        return getServletRequestAttributes().getResponse();
    }

    /**
     * 获取session
     */
    public static HttpSession getSession() {
        return getServletRequestAttributes().getRequest().getSession();
    }

    public static ServletRequestAttributes getServletRequestAttributes() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) requestAttributes;
    }

    /**
     * 判断是否为Ajax异步请求
     * @param request
     * @return boolean
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String accept = request.getHeader("accept");
        if (accept != null && accept.indexOf("application/json") != -1) {
            return true;
        }

        String xRequestedWith = request.getHeader("X-Requested-With");
        if (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1) {
            return true;
        }

        String uri = request.getRequestURI();
        if (StringUtils.inStringIgnoreCase(uri, ".json", ".xml")) {
            return true;
        }

        String ajax = request.getParameter("__ajax");
        if(StringUtils.inStringIgnoreCase(ajax, "json", "xml")) {
            return true;
        }

        return  false;
    }

    /**
     * 将字符串渲染到客户端
     * @param response 渲染对象
     * @param str 待渲染的字符串
     * @return null
     */
    public static String renderStringToRes(HttpServletResponse response, String str) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(str);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
