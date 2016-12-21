package com.zjut.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @author chen-zhiqiang
 *
 * @version 创建时间：2016年12月13日下午2:38:02
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	private String loginUrl;
	private String loginActionUrl;

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLoginActionUrl() {
		return loginActionUrl;
	}

	public void setLoginActionUrl(String loginActionUrl) {
		this.loginActionUrl = loginActionUrl;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		//System.out.println("LoginCheckInterceptor!");
		//System.out.println(request.getServletPath());
		// 1、请求到登录页面 放行
		if (request.getServletPath().startsWith(loginUrl)) {
			return true;
		}

		// 在登录页面点击登录按钮进行登录放行
		if (request.getServletPath().startsWith(loginActionUrl) && "POST".equals(request.getMethod())
				&& "login".equals(request.getParameter("action"))) {
			System.out.println("用户登录");
			return true;
		}

		// 2、TODO 比如退出、首页等页面无需登录，即此处要放行 允许游客的请求

		// 3、如果用户已经登录 放行
		if (request.getSession().getAttribute("user") != null) {
			// 更好的实现方式的使用cookie
			return true;
		}

		// 4、非法请求 即这些请求需要登录后才能访问
		// 重定向到登录页面
		System.out.println("check:not login");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(
				"<script language=\"javascript\">alert('对不起您无权访问，请先登录！');parent.location.href='/JConsoleGroup/adminAction/loginPage.action'</script>");
		return false;
	}

}
