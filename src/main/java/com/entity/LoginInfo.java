package com.entity;

import com.framework.aspectj.annotation.Excel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author chuqian
 * @Date created in 2019/1/30 21:49
 * @describe 系统访问记录
 */
@Entity
@Table(name = "t_login_info")
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = -2162820864170282038L;

    /** ID */
    @Excel(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_LOGIN_INFO", allocationSize = 1)
    private Long login_info_id;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String loginName;

    /** 登录状态 1成功 0失败 */
    @Excel(name = "登录状态", readConverterExp = "1=成功,0=失败")
    private String status;

    /** 登录IP地址 */
    @Excel(name = "登录地址")
    private String ipaddr;

    /** 登录地点 */
    @Excel(name = "登录地点")
    private String loginLocation;

    /** 浏览器类型 */
    @Excel(name = "浏览器")
    private String browser;

    /** 操作系统 */
    @Excel(name = "操作系统 ")
    private String os;

    /** 提示消息 */
    @Excel(name = "提示消息")
    private String msg;

    /** 访问时间 */
    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getLogin_info_id() {
        return login_info_id;
    }

    public void setLogin_info_id(Long login_info_id) {
        this.login_info_id = login_info_id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getLoginLocation() {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
