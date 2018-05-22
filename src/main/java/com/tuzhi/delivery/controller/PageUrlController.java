package com.tuzhi.delivery.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuzhi.delivery.base.BaseController;

/**
 * @author codeZ
 * @date 2018年3月16日 下午4:51:09
 * 
 */

@Controller
public class PageUrlController extends BaseController{

	/**
	 * 页面跳转公共路径(根据下面的模块名称和操作跳转到具体的页面)
	 * @param module  模块名称
	 * @param hanlder 操作名称
	 * @return 视图路径(具体路径需要结合springmvc里面的模型视图控制器的前缀和后缀)
	 * @throws IOException 
	 */
	@RequestMapping("page/{module}/{hanlder}")
	public String page(@PathVariable(name="module")String module ,
				@PathVariable(name="hanlder")String hanlder) throws IOException{
		//汇交办理和审核办理拦截一下,做些处理,以免配菜单出现错误导致业务出错
		if(("deliver".equals(module)&&getUserType()!=0)||("examinie".equals(module)&&getUserType()!=1))
			response.sendError(403);
		
		return module + "/" + hanlder ;
	}
	
	@RequestMapping("index")
	public String home(){
		return "redirect:/index.jsp";
	}
	
}
