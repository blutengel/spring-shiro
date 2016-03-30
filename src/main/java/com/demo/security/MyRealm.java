package com.demo.security;

import com.demo.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Alan Cheung on 2016/3/23.
 * 实际使用应该从数据中读取用户身份信息及权限
 * sys_users, sys_roles, sys_user_role
 */
public class MyRealm extends AuthorizingRealm {

    public static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.warn("doGetAuthorizationInfo");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        logger.warn("doGetAuthenticationInfo");

        // 从SecurityManager中的token获得用户登录的身份信息
        String username = (String) token.getPrincipal();

        // 根据username从数据中查找此用户，返回用户信息
        // 用数据中的用户信息与登录时的信息进行验证，通过返回认证信息，失败返回Null

        User user = new User("alan", "a");
        if (user != null) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "xx");
            return authcInfo;
        } else {
            return null;
        }
    }
}
