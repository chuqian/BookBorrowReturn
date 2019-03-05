package com.controller;

import com.web.common.AjaxResult;
import com.web.utils.ServletUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author chuqian
 * @Date created in 2019/1/20 10:25
 * @describe
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        // 如果是Ajax请求，返回Json字符串
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderStringToRes(response, "{\"code\":\"1\", \"msg\":\"未登录或登录超时, 请重新登录\"}");
        }
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return AjaxResult.success();
        }
        catch (AuthenticationException e) {
            String msg = "用户名或密码错误";
            if (e != null && !(e.getMessage().isEmpty())) {
                msg = e.getMessage();
            }
            return AjaxResult.error(msg);
        }
    }

    /**
     * 权限认证失败
     * @return
     */
    @GetMapping("/unauth")
    public String unauth() {
        return "/error/unauth";
    }
}
