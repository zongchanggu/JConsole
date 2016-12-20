package com.zjut.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user_info")
	public String user_info() {
		String viewName = "/adminPages/user_info";
		return viewName;
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/alter_pass")
	public String alter_pass() {
		String viewName = "/adminPages/alter_pass";
		return viewName;
	}

	/**
	 * 用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user_list")
	public String user_list() {
		String viewName = "/adminPages/user_list";
		return viewName;
	}

	/**
	 * 通过页码和每页包含的数据条数来获取当前页的用户信息
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/getUserList")
	@ResponseBody
	public JsonDataInfo<User> getUserList(int page, int rows, String username, String phone, String usertype) {
		JsonDataInfo<User> datas = new JsonDataInfo<User>();
		int firstRowNum = (page - 1) * rows;
		int lastRowNum = page * rows;
		List<User> userlist;
		if ((username==null) && (phone==null) && (usertype==null)) {
			userlist = userServiceImpl.getPageUserListByFL(firstRowNum, lastRowNum);
			/*
			 * List<Map<String, String>> formattedDatas = new ArrayList<>();
			 * String key, value; for (User user : userlist) { Map<String,
			 * String> data = new HashMap<>(); key = "userId"; value =
			 * Integer.toString(user.getUserID()); data.put(key, value); key =
			 * "username"; value = user.getUserName(); data.put(key, value); key
			 * = "password"; value = user.getPassWord(); data.put(key, value);
			 * key = "phone"; value = user.getPhone(); data.put(key, value); key
			 * = "type"; value = Integer.toString(user.getType());
			 * System.out.println("type:" + user.getType()); data.put(key,
			 * value); key = "currentTime"; value =
			 * user.getCurrentTime().toString(); System.out.println(value);
			 * data.put(key, value); formattedDatas.add(data); }
			 */
			datas.setTotal(userServiceImpl.getTotalNum());
			datas.setRows(userlist);
			System.out.println("total:" + userServiceImpl.getTotalNum());
		} else {// 进入搜索
			userlist = userServiceImpl.searchPageUserList(firstRowNum, lastRowNum, username, phone, usertype);
			datas.setTotal(userlist.size());
			datas.setRows(userlist);
		}
		return datas;
	}

	/**
	 * 根据userId获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getUserDetail", method = { RequestMethod.POST })
	public ModelAndView getUserDetail(int id, Model user) {
		User userInfo = userServiceImpl.getUserById(id);
		user.addAttribute(userInfo);
		ModelAndView mView = new ModelAndView();
		String viewName = "/adminPages/userDetail";
		mView.setViewName(viewName);
		// request.setAttribute("userDetail", userDetail);
		return mView;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
