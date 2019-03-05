package com.entity;

import com.shiro.session.OnlineSession;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 当前在线会话 sys_user_online
 * 
 */
@Entity
@Table(name = "t_user_online")
public class UserOnline extends BaseEntity {

    private static final long serialVersionUID = 4054945891184334751L;

    /** 用户会话id */
    @Id
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "SEQ_T_USER_ONLINE", allocationSize = 1)*/
    private String id;

    /** 部门名称 */
    private String deptName;

    /** 登录名称 */
    private String loginName;

    /** 登录IP地址 */
    private String ipaddr;

    /** 登录地址 */
    private String loginLocation;

    /** 浏览器类型 */
    private String browser;

    /** 操作系统 */
    private String os;

    /** session创建时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTimestamp = new Date();

    /** session最后访问时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastAccessTime = new Date();

    /** 超时时间，单位为分钟 */
    private Long expireTime;

    /** 在线状态 */
    @Transient
    private OnlineSession.OnlineStatus status = OnlineSession.OnlineStatus.on_line;

    /** 备份的当前用户会话 */
    @Transient
    private OnlineSession session;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getIpaddr()
    {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr)
    {
        this.ipaddr = ipaddr;
    }

    public String getLoginLocation()
    {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation)
    {
        this.loginLocation = loginLocation;
    }

    public String getBrowser()
    {
        return browser;
    }

    public void setBrowser(String browser)
    {
        this.browser = browser;
    }

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    public Date getStartTimestamp()
    {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp)
    {
        this.startTimestamp = startTimestamp;
    }

    public Date getLastAccessTime()
    {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime)
    {
        this.lastAccessTime = lastAccessTime;
    }

    public Long getExpireTime()
    {
        return expireTime;
    }

    public void setExpireTime(Long expireTime)
    {
        this.expireTime = expireTime;
    }

    public OnlineSession.OnlineStatus getStatus()
    {
        return status;
    }

    public void setStatus(OnlineSession.OnlineStatus status)
    {
        this.status = status;
    }

    public OnlineSession getSession()
    {
        return session;
    }

    public void setSession(OnlineSession session)
    {
        this.session = session;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sessionId", getId())
            .append("loginName", getLoginName())
            .append("deptName", getDeptName())
            .append("ipaddr", getIpaddr())
            .append("loginLocation", getLoginLocation())
            .append("browser", getBrowser())
            .append("os", getOs())
            .append("status", getStatus())
            .append("startTimestamp", getStartTimestamp())
            .append("lastAccessTime", getLastAccessTime())
            .append("expireTime", getExpireTime())
            .toString();
    }
}
