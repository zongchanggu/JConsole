package com.zjut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月13日</p>
 */
@Controller
@RequestMapping("devCheck")
public class DevCheck {
	
	@RequestMapping("doHealthCheck")
	public String doHealthCheck(){
		return "index";
	}

}
