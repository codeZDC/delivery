package com.tuzhi.delivery.shiro.permission;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.tuzhi.delivery.base.Constant;
import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.service.IMenuService;
import com.tuzhi.delivery.service.IUserService;

public class UrlPermissionFilter extends AccessControlFilter {

	@Autowired
	private IUserService userService;
	@Autowired
	private IMenuService menuService;

	private String errorUrl;
	Logger logger = Logger.getLogger(UrlPermissionFilter.class.getName());

	public String getErrorUrl() {
		return errorUrl;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		try {
			Subject subject = getSubject(request, response);
			if (subject == null) {
				return false;
			}
			HttpSession session = ((HttpServletRequest) request).getSession();
			User user = (User) session.getAttribute(Constant.SESSION_USER);
			Object recs = session.getAttribute(Constant.SESSION_MENU);
			// 判断session是否失效，若失效刷新之
			if (user == null || recs == null) {
				String username = (String) subject.getPrincipal();
				user = new User();
				user.setUsername(username);
				user = userService.selectOne(user);
				session.setAttribute(Constant.SESSION_USER, user);
				session.setAttribute(Constant.SESSION_MENU, menuService.getMenusByRoleId(user.getRoleId()));
			}
			return true;
		} catch (Exception e) {
			logger.error("应该是根据用户名查找用户结果为空!");
			((HttpServletResponse) response).sendError(403);
			return true;
		}
	}

	/**
	 * 表示是否允许访问 ，如果允许访问返回true，否则false；
	 * 
	 * @param request
	 * @param response
	 * @param o
	 *            表示写在拦截器中括号里面的字符串 mappedValue 就是 [urls] 配置中拦截器参数部分
	 * @return
	 * @throws Exception
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {
		// Subject subject = getSubject(request,response);
		// String url = getPathWithinApplication(request);
		// logger.debug("当前用户正在访问的 url => " + url);
		// return subject.isPermitted(url);
		return true;
	}

	/**
	 * onAccessDenied：表示当访问拒绝时是否已经处理了；如果返回 true 表示需要继续处理；如果返回 false
	 * 表示该拦截器实例已经处理了，将直接返回即可。
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		logger.debug("当 isAccessAllowed 返回 false 的时候，才会执行 method onAccessDenied ");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		/*
		 * 下面有两个response,第一个是张东,第二个是我 <真实情况下需要未授权提醒????防恶意攻击??对坏人需要友好提醒??>
		 * <我感觉我的这个方法更好,毕竟现在异步情况需要的地方太多了,但是其实根本没得用,自己写的异步,还没授权?>
		 * 他把访问未授权url的用户直接重定向到未授权友好页面(errorUrl),已经在spring-shiro.xml中赋值
		 * 我采用的是设置401未授权状态码,氛围同步和异步情况如下:
		 * 异步访问的时候通过ajax中statusCode:{401:function(){location??}}可以跳转到未授权页面
		 * 同步访问的时候通过web.xml中的error-page中error-code=401设置跳转未授权页面
		 */

		// 可以使用request.getRequestUri得到被拒绝访问的路径
		// 下面两个response只能使用一个,,只能响应一次嘛,,关于errorUrl是在申明自定义过滤器的时候设置的属性,
		// 在spring-shiro.xml中可查看unauthorizedzhengdechao
		// response.sendRedirect(request.getContextPath() + this.errorUrl);
		// request.getRequestDispatcher(this.errorUrl).forward(request,
		// response);
		logger.error("当前访问: " + request.getRequestURI() + " , 未授权.....401");
		response.sendError(401, "未授权");
		// 返回 false 表示已经处理，例如页面跳转啥的，表示不在走以下的拦截器了（如果还有配置的话）
		return false;
	}

}
