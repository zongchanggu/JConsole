package com.zjut.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjut.pojo.JsonDataInfo;
import com.zjut.pojo.User;
import com.zjut.service.IUserService;

/**
 * 
 * @author chen-zhiqiang
 *
 * @version 创建时间：2016年12月10日下午10:07:19
 */

@Controller
@RequestMapping("/adminAction")
public class AdminAction {
	
	@Resource
	private IUserService userServiceImpl;
	
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
	 * 用户列表
	 * @return
	 */
	@RequestMapping(value = "/user_list")
	public String user_list(){
		String viewName = "/adminPages/user_list";
		return viewName;
	}
	
	/**
	 * 通过页码和每页包含的数据条数来获取当前页的用户信息
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/getUserList")
	@ResponseBody
	public JsonDataInfo<Map<String, String>> getUserList(int page, int rows){
		JsonDataInfo<Map<String, String>> datas = new JsonDataInfo<Map<String, String>>();
		int firstRowNum = (page-1)*rows;
		int lastRowNum = page * rows - 1;
		List<User> userlist = userServiceImpl.getPageUserListByFL(firstRowNum, lastRowNum);
		List<Map<String, String>> formattedDatas = new ArrayList<>();
		String key, value;
		for (User user : userlist) {
			Map<String, String> data = new HashMap<>();
			key = "userId";
			value = Integer.toString(user.getUserID());
			data.put(key, value);
			key = "username";
			value = user.getUserName();
			data.put(key, value);
			key = "password";
			value = user.getPassWord();
			data.put(key, value);
			key = "phone";
			value = user.getPhone();
			data.put(key, value);
			key = "type";
			value = Integer.toString(user.getType());
			System.out.println("type:" + user.getType());
			data.put(key, value);
			key = "currentTime";
			value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getCurrentTime());
			data.put(key, value);
			formattedDatas.add(data);
		}
		datas.setTotal(userServiceImpl.getTotalNum());
		datas.setRows(formattedDatas);
		System.out.println("total:" + userServiceImpl.getTotalNum());
		return datas;
	}

	/**
	 * 根据userId获取用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getUserDetail", method = {RequestMethod.POST})
	public ModelAndView getUserDetail(int id){
		User user = userServiceImpl.getUserById(id);
		ModelAndView mView = new ModelAndView();
		mView.addObject("user", user);
		String viewName = "/adminPages/userDetail";
		mView.setViewName(viewName);
		//request.setAttribute("userDetail", userDetail);
		return mView;
	}

}
