package com.zjut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author chen-zhiqiang
 *
 * @version 创建时间：2016年12月10日下午10:07:19
 */

@Controller
@RequestMapping("/adminAction")
public class AdminAction {
	
	/**
	 * 个人信息
	 * @return
	 */
	@RequestMapping(value = "/user_info")
	public String user_info(){
		String viewName = "/adminPages/user_info";
		return viewName;
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	@RequestMapping(value = "/alter_pass")
	public String alter_pass(){
		String viewName = "/adminPages/alter_pass";
		return viewName;
	}
	
	/**
	 * 获取用户列表
	 * @return
	 */
	@RequestMapping(value = "user_list")
	public String user_list(){
		String viewName = "/adminPages/user_list";
		return viewName;
	}

}
