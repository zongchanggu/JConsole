package com.zjut.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * @author chen-zhiqiang
 *
 * @version 创建时间：2016年12月8日下午10:28:09
 */

@Controller
@RequestMapping("/adminAction")
public class AdminLoginAction {
	
	public static final String GET_METHOD = "GET";
	public static final String POST_METHOD = "POST";
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String adminLoginPage(){
		System.out.println("loginPage");
		String viewName = "/adminPages/login";
		return viewName;
	}
	
	/**
	 * 形参username和password是页面表单传过来的用户名和密码
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String adminLogin(String username, String password, HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		String reqMethod = request.getMethod();
		String viewName = "/adminPages/admin";
		if(GET_METHOD.equals(reqMethod)){//Get方式请求，用户在浏览器直接输入地址请求
			//判断是否已经登录
			if(session.getAttribute("username")==null){//未登录，提示用户并重定向到登录界面
				response.setContentType("text/html;charset=utf-8");
				viewName = "/adminPages/login";
				try {
					PrintWriter out = response.getWriter();
					
					out.print("<script language=\"javascript\">alert('对不起您无权访问，请先登录！');window.location.href='/JConsoleGroup/adminAction/loginPage.action'</script>");
					return null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//已经登录
			return viewName;
		}else{//Post方式请求，说明用户在登录界面点击了登录按钮
			System.out.println("username:" + username);
			System.out.println("password:" + password);
			//存入session
			session.setAttribute("username", username);
			return viewName;
		}
		
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String adminLogout(HttpSession session){
		String viewName = "/adminPages/login";
		session.invalidate();
		return viewName;
	}

}
