package com.tuzhi.delivery.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseController;
import com.tuzhi.delivery.base.Constant;
import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.domain.vo.MenuVo;
import com.tuzhi.delivery.domain.vo.UserExtend;
import com.tuzhi.delivery.service.IMenuService;
import com.tuzhi.delivery.service.IUserService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.Tz;

import tk.mybatis.mapper.util.StringUtil;

/**
 * @ClassName:UserController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-22 15:07:36
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	private static final String User = null;
	@Autowired
	private IUserService userService;
	@Autowired
	private IMenuService menuService;
	
	 /**
	 * @title:findUserList
	 * @description: 分页
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-03-22 15:07:36
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findUserList(User user){
		PageInfo<User> page = userService.findUserList(user);
		return bootstrapTable(page);//PageInfo<User>
	}
	
	/**
	 * @title:getUserById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-22 15:07:36
	 */
	@RequestMapping("/get")
	@ResponseBody
	public User getUserById(Integer id){
		User user = userService.getUserById(id);
		return user;
	}
	
	/**
		@title:getUserByZone
	 * @description: 根据汇交区域查询审核人
	 * @author 贺保铭
	 * @param id
	 * @CreateDate  2018-03-30 11:43:36
	 */
	@RequestMapping("getExaminerByzone")
	@ResponseBody
	public Object getExaminerByZone(String zoneCode) {
		System.out.println("zoneCode :" + zoneCode);
		//zoneCode = (zoneCode == null || "".equals(zoneCode)) ? "":;
		return userService.getExaminerByZoneCode(zoneCode);
	}
	
	
	 /**
	 * @title:editUser
	 * @description: 新增
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-03-22 15:07:36
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveUser(User user){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = userService.saveUser(user);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editUser
	 * @description: 修改
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-03-22 15:07:36
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editUser(User user){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = userService.editUser(user);
		//修改密码的时候需要修改登录用户信息
		if(user.getId().intValue() == getUserId().intValue()){
			updateUser(user);//不需要反射,,值修改固定几项即可
		}
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	
	 /**
	 * @title:delUser
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-22 15:07:36
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delUser(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = userService.delUser(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
	
	//用户登录
	@RequestMapping("/admin/login")
	public String login(User user, boolean rememberMe , Model model) throws UnsupportedEncodingException{
		if(user==null||StringUtil.isEmpty(user.getUsername())||StringUtil.isEmpty(user.getPassword())){
			//说明是直接登录的
			return "redirect:/login.jsp";
		}
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword(),rememberMe);
		try {
			subject.login(token);
		}catch (Exception  e) {
			model.addAttribute("username", user.getUsername());
			if(e instanceof UnknownAccountException){
				model.addAttribute("msg", "未知账户!");
			}else if(e instanceof IncorrectCredentialsException){
				model.addAttribute("msg", "密码错误!");
			}else{
				model.addAttribute("msg", "后端报错啦!");
			}
			return "redirect:/login.jsp";
		}
		saveSessionUser(user);//保存在session中...
		//获取用户菜单保存在session中...request?session?
		List<MenuVo> menuList = menuService.getMenusByRoleId(getRoleId());
		session.setAttribute(Constant.SESSION_MENU, menuList);
		return "redirect:/index";
	}
	
	private Integer getRoleId() {
		Integer roleId = ((User)session.getAttribute(Constant.SESSION_USER)).getRoleId();
		return roleId;
	}

	private void saveSessionUser(User user) {
		user.setPassword(null);
		user = userService.selectOne(user);
		session.setAttribute(Constant.SESSION_USER, user);
	}
	
	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("getRoleId")
	@ResponseBody
	public Integer getRoleId2(){
		return getRoleId();
	}
	
	//更新用户是否可用状态
	@RequestMapping("updateStatus")
	@ResponseBody
	public Tz updateStatus(Integer id,Integer status){
		userService.updateStatus(id,status);
		return Tz.success();
	}
	
	//更新用户是否可用状态
	@RequestMapping("reasonableUsername")
	@ResponseBody
	public Tz reasonableUsername(String username){
		int i = userService.reasonableUsername(username);
		if(i>0)return Tz.fail();
		return Tz.success();
	}
	
}
