package com.tuzhi.delivery.shiro.realm;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.mapper.IUserMapper;


public class MyRealm extends AuthorizingRealm  {
	
	private Logger logger = Logger.getLogger(MyRealm.class.getName());
	@Autowired
	private IUserMapper userMapper;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		/*System.out.println("**********************权限信息****************");
		User user = (User)arg0.getPrimaryPrincipal();
		Integer userId = user.getId();
		List<String> resources = userMapper.getResources(userId);
		List<String> roles =userMapper.getRoles(userId);
		List<String> permissions = userMapper.getPermissions(userId);
		
		if(user!=null){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.setRoles(new HashSet<String>(roles));
			info.setStringPermissions(new HashSet<String>(resources));
			info.addStringPermissions(permissions);
			return info;
		}*/
		return null;
	}


	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO 认证处理
		System.out.println("**********************认证信息****************");
		String username = (String)token.getPrincipal();
		User user = new User();
		user.setUsername(username);
		user = userMapper.selectOne(user);
		if(user!=null){
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
			//不需要加盐info.setCredentialsSalt(ByteSource.Util.bytes(user.getAccount()));
			return info;
		}
		return null;
	}

    protected void 没有开启认证缓存clearCachedAuthenticationInfo(PrincipalCollection principals) {
       try {
    	   Cache c = getAuthenticationCache();
           logger.info("清除【认证】缓存之前");
           for(Object o : c.keys()){
               logger.info( o + " , " + c.get(o));
           }
           super.clearCachedAuthenticationInfo(principals);
           logger.info("调用父类清除【认证】缓存之后");
           for(Object o : c.keys()){
               logger.info( o + " , " + c.get(o));
           }

           // 添加下面的代码清空【认证】的缓存
           /** 我测试的结果(大概可以这么认为):由于我们在MyRealm中传入的第一个参数为user,
            *	所以上面的父类的清除的key=principals.getPrimaryPrincipal()=user对象,
           	但是缓存中存放的key为当前用户的账户,即user.getUsername();所以的下面的spc去进行清除,
           	如果MyRealm中的第一个参数和账户名相同的话,上面调用就可以清除,不用下面*/
           //User user = (User) principals.getPrimaryPrincipal();
           //SimplePrincipalCollection spc = new SimplePrincipalCollection(user.getUsername(),getName());
           SimplePrincipalCollection spc = new SimplePrincipalCollection(principals.getPrimaryPrincipal(),getName());
           super.clearCachedAuthenticationInfo(spc);
           logger.info("添加了代码清除【认证】缓存之后");
           int cacheSize = c.keys().size();
           logger.info("【认证】缓存的大小:" + c.keys().size());
           if (cacheSize == 0){
               logger.info("说明【认证】缓存被清空了。");
           }
		} catch (Exception e) {
			logger.error("清空认证缓存失败,,应该是没有开启登录缓存");
		}
    }

    protected void 没有开启权限缓存clearCachedAuthorizationInfo(PrincipalCollection principals) {
        try {
        	logger.info("清除【授权】缓存之前");
            Cache c = getAuthorizationCache();
            for(Object o : c.keys()){
                logger.info( o + " , " + c.get(o));
            }
            super.clearCachedAuthorizationInfo(principals);
            logger.info("清除【授权】缓存之后");
            int cacheSize = c.keys().size();
            logger.info("【授权】缓存的大小:" + cacheSize);

            for(Object o : c.keys()){
                logger.info( o + " , " + c.get(o));
            }
            if(cacheSize == 0){
                logger.info("说明【授权】缓存被清空了。");
            }
		} catch (Exception e) {
			logger.error("清空权限缓存失败,,可能是没有开启权限缓存");
		}
    }
}
