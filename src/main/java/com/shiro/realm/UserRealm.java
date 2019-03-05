package com.shiro.realm;

import com.controller.LoginController;
import com.entity.User;
import com.service.LoginService;
import com.service.MenuService;
import com.service.RoleService;
import com.web.exception.*;
import com.web.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author chuqian
 * @Date created in 2019/1/24 22:23
 * @describe 自定义Realm，处理授权、登录认证
 */
public class UserRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private LoginService loginService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    /**
     * 授权
     * @param principals
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = ShiroUtils.getSysUser();
        Set<String> roles = new HashSet<>();  //角色列表
        Set<String> menus = new HashSet<>();  //功能列表
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //管理员拥有所有权限
        if (user.isAdmin()) {
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        }
        else {
            //roles = roleService.selectRoleKeys(user.getUser_id());
            //menus = menuService.selectPermsByUserId(user.getUser_id());
            info.setRoles(roles);   //AuthorizationInfo认证对象中加入角色
            info.setStringPermissions(menus);  //AuthorizationInfo认证对象中加入权限
        }
        return info;
    }

    /**
     * 登录认证
     * @param token
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        String password = "";

        if (usernamePasswordToken.getPassword() != null) {
            password = new String(usernamePasswordToken.getPassword());
        }

        User user = null;
        try {
            user = loginService.login(username, password);
        }
         //验证码错误
        catch (CaptchaException e) {
            throw new AuthenticationException(e.getMessage(), e);
        }
        //用户不存在
        catch (UserNotExistsException e) {
            throw new UnknownAccountException(e.getMessage(), e);
        }
        //用户密码不正确
        catch (UserPasswordNotMatchException e) {
            throw new IncorrectCredentialsException(e.getMessage(), e);
        }
        //密码错误次数过多
        catch (UserPasswordRetryLimitExceedException e) {
            throw new ExcessiveAttemptsException(e.getMessage(), e);
        }
        //用户锁定
        catch (UserBlockedException e) {
            throw new LockedAccountException(e.getMessage(), e);
        }
        catch (Exception e) {
            log.info("对用户[" + username + "]进行登录验证....验证未通过{}", e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

    /**
     * @Author chuqian
     * @Date created in 2019/1/30 20:35
     * @Return void
     * @describe 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}