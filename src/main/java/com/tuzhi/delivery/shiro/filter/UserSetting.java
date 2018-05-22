package com.tuzhi.delivery.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.tuzhi.delivery.base.Constant;
import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.service.IMenuService;
import com.tuzhi.delivery.service.IUserService;

/** 
 * @author codeZ 暂时用不到
 * @date 2018年3月26日 下午4:17:43
 * 
 */
public class UserSetting extends AccessControlFilter {  
    
    @Autowired  
    private IUserService userService;  
    @Autowired
    private IMenuService menuService;

    @Override  
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {  
        Subject subject = getSubject(request, response);  
        if (subject == null) {  
            return false;  
        }  
        HttpSession session = ((HttpServletRequest)request).getSession();  
        User user = (User) session.getAttribute(Constant.SESSION_USER);  
        Object recs = session.getAttribute(Constant.SESSION_MENU);  
        //判断session是否失效，若失效刷新之  
        if(user == null || recs == null){  
            String username = (String) subject.getPrincipal(); 
            user = new User();
            user.setUsername(username);
            user = userService.selectOne(user);  
            session.setAttribute(Constant.SESSION_USER, user);  
            session.setAttribute(Constant.SESSION_MENU, menuService.getMenusByRoleId(user.getRoleId()));
        }  
        return true;  
    }  
  
    @Override  
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)  
            throws Exception {  
        return true;  
    }  
  
    @Override  
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {  
        return true;  
    }  
  
}  