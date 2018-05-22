package com.tuzhi.delivery.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;


public class UrlPermissionResolver implements PermissionResolver {
   // org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UrlPermissionResolver.class.getName());
    /**
     * 经过调试发现
     * subject.isPermitted(url) 中传入的字符串
     * 和自定义 Realm 中传入的权限字符串集合都要经过这个 resolver
     * @param s
     * @return
     */
    public Permission resolvePermission(String s) {
       // logger.debug("s => " + s);

        if(s.startsWith("/")){
            return new UrlPermission(s);
        }
        return new WildcardPermission(s);
    }
}