package com.zjut.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjut.pojo.User;
import com.zjut.service.IUserService;
/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月11日</p>
 *
 */
@Controller
@RequestMapping("userAction")
public class UserAction {
	@Resource
	private IUserService userServiceImpl;
	
	@RequestMapping("getUser")
	public String getUser(){
		User user= userServiceImpl.getUserById(1);
		System.out.println(user.getUser_name()+":"+user.getPassword());
		return "index";
	}

}
