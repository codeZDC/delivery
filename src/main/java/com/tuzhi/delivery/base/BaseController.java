package com.tuzhi.delivery.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.util.BootstrapTable;

/**
 * 父类控制器
 * @author 郑德超
 *
 * 2017年3月15日 下午2:14:24
 */
@SuppressWarnings("deprecation")
public class BaseController {
	private static final String User = null;
	//protected String SESSION_USER = Constant.SESSION_USER;	//PC session
	public final String WECHATUSER = "WECHATUSER";		//微信 session
	protected static ObjectMapper mapper = new ObjectMapper();
	protected static JsonFactory factory = mapper.getJsonFactory();
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	/**将json字符串输出**/
	protected void writeJSON(String json) throws IOException {
		try {
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		}catch(IOException e){ 
			e.printStackTrace();
		}
	}
	/**将对象转成json输出**/
	protected void writeJSON(Object obj){
		response.setContentType("text/json;charset=utf-8");
		try {
			JsonGenerator responseJsonGenerator = factory.createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
			responseJsonGenerator.writeObject(obj);
			responseJsonGenerator.flush();
			responseJsonGenerator.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**分页json输出**/
	protected void writePage(PageInfo<?> pageInfo){
		response.setContentType("text/html;charset=utf-8");
		try {
			JsonGenerator responseJsonGenerator = factory.createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
			Map<String, Object> pageMap = new HashMap<String, Object>();
			pageMap.put("total", pageInfo.getTotal());
			pageMap.put("rows", pageInfo.getList());
			responseJsonGenerator.writeObject(pageMap);
			responseJsonGenerator.flush();
			responseJsonGenerator.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**分页json输出**/
	protected void writePages(PageInfo<?> pageInfo){
		response.setContentType("text/html;charset=utf-8");
		try {
			JsonGenerator responseJsonGenerator = factory.createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
			
			Map<String, Object> pageMap = toPageMap(pageInfo);
			
			responseJsonGenerator.writeObject(pageMap);
			responseJsonGenerator.flush();
			responseJsonGenerator.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected String getProjectPath() {
		return request.getServletContext().getRealPath("/");
	}
	
	protected Map<String, Object> toPageMap(PageInfo<?> pageInfo) {
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("total", pageInfo.getTotal());//总记录数
		pageMap.put("rows", pageInfo.getList());//结果集
		pageMap.put("pages", pageInfo.getPages());//总页数
		pageMap.put("pageNum", pageInfo.getPageNum());//当前页
		pageMap.put("prePage", pageInfo.getPrePage());//前一页
		pageMap.put("nextPage", pageInfo.getNextPage());//下一页
		pageMap.put("navigatepageNums", pageInfo.getNavigatepageNums());//所有导航页号
		pageMap.put("navigateFirstPage", pageInfo.getNavigateFirstPage());//首页
		pageMap.put("navigateLastPage", pageInfo.getNavigateLastPage());//尾页
		pageMap.put("navigatePages", pageInfo.getNavigatePages());//导航页码数
		return pageMap;
	}	
	
	protected BootstrapTable bootstrapTable(PageInfo<?> page){
		return new BootstrapTable(page.getTotal(), page.getList());
	}
	
	//获取用户信息之userId
	protected Integer getUserId(){
		return ((User)session.getAttribute(Constant.SESSION_USER)).getId();
	}
	//获取用户信息之行政区域
	protected String getAdmZone(){
		return ((User)session.getAttribute(Constant.SESSION_USER)).getAdmZone();
	}
	//获取用户信息之汇交区域
	protected String getDeliveryZone(){
		return ((User)session.getAttribute(Constant.SESSION_USER)).getDeliveryZone();
	}
	//获取用户信息之userType
	protected Integer getUserType(){
		return ((User)session.getAttribute(Constant.SESSION_USER)).getUserType();
		
	}
	//获取用户资质
	protected Integer getUserQualification() {
		return ((User)session.getAttribute(Constant.SESSION_USER)).getQualification();
	}
	
	
	//修改密码,修改登录用户的session信息
	protected void updateUser(User user){
		//修改指定的几个字段
		User sessionUser = (User)session.getAttribute(Constant.SESSION_USER);
		sessionUser.setUnitAddr(user.getUnitAddr());
		sessionUser.setPassword(user.getPassword());
		sessionUser.setPhoneNumber(user.getPhoneNumber());
		sessionUser.setContact(user.getContact());
		session.setAttribute(Constant.SESSION_USER, sessionUser);
	}
	
}
