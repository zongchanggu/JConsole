package com.zjut.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjut.pojo.User;
import com.zjut.service.IUserService;

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
