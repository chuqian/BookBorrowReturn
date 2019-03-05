package com.web.manager.factory;

import com.entity.OperLog;
import com.entity.UserOnline;
import com.service.IUserOnlineService;
import com.service.impl.LogininforServiceImpl;
import com.shiro.session.OnlineSession;
import com.web.common.Constants;
import com.web.domain.Logininfor;
import com.web.utils.AddressUtils;
import com.web.utils.LogUtils;
import com.web.utils.ServletUtils;
import com.web.utils.ShiroUtils;
import com.web.utils.spring.SpringUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * @Author chuqian
 * @Date created in 2019/1/31 20:27
 * @describe 异步工厂(用于产生工厂)
 */
public class AsyncFactory {
    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys_user");

    /**
     * 同步session到数据库
     *
     * @param session 在线用户会话
     * @return 任务task
     */
    public static TimerTask syncSessionToDb(final OnlineSession session)
    {
        return new TimerTask()
        {
            @Override
            public void run()
            {
                UserOnline online = new UserOnline();
                online.setId(String.valueOf(session.getUserId()));
                online.setDeptName(session.getDeptName());
                online.setLoginName(session.getLoginName());
                online.setStartTimestamp(session.getStartTimestamp());
                online.setLastAccessTime(session.getLastAccessTime());
                online.setExpireTime(session.getTimeout());
                online.setIpaddr(session.getHost());
                online.setLoginLocation(AddressUtils.getRealAddressByIP(session.getHost()));
                online.setBrowser(session.getBrowser());
                online.setOs(session.getOs());
                online.setStatus(session.getStatus());
                online.setSession(session);
                SpringUtils.getBean(IUserOnlineService.class).saveOnline(online);

            }
        };
    }

    /**
     * 记录操作日志
     * @param operLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final OperLog operLog) {
        return new TimerTask() {
            @Override
            public void run() {
                operLog.getOperLocation();
            }
        };
    }

    /**
     * 记录登陆信息
     * @param username 用户名
     * @param status 状态
     * @param message 消息
     * @param args 列表
     * @return 任务task
     */
    public static TimerTask recordLogininfor(final String username, final String status, final String message, final Object... args)
    {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = ShiroUtils.getIp();

        return new TimerTask()
        {
            @Override
            public void run()
            {
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(AddressUtils.getRealAddressByIP(ip));
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印信息到日志
                sys_user_logger.info(s.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                Logininfor logininfor = new Logininfor();
                logininfor.setLoginName(username);
                logininfor.setIpaddr(ip);
                logininfor.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
                logininfor.setBrowser(browser);
                logininfor.setOs(os);
                logininfor.setMsg(message);
                // 日志状态
                if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status))
                {
                    logininfor.setStatus(Constants.SUCCESS);
                }
                else if (Constants.LOGIN_FAIL.equals(status))
                {
                    logininfor.setStatus(Constants.FAIL);
                }
                // 插入数据
                SpringUtils.getBean(LogininforServiceImpl.class).insertLogininfor(logininfor);
            }
        };
    }
}
