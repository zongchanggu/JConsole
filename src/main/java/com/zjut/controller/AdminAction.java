package com.zjut.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public JsonDataInfo getUserList(int page, int rows){
		JsonDataInfo datas = new JsonDataInfo();
		int firstRowNum = (page-1)*rows + 1;
		int lastRowNum = page * rows;
		List<Object> formattedDatas = new ArrayList<>();
		List<User> userlist = new ArrayList<>();
		User user1 = new User();
		user1.setUserName("你好");
		user1.setUserID(1);
		user1.setID(1);
		user1.setCurrentTime(new Date());
		user1.setPassWord("123456");
		user1.setPhone("18767671212");
		user1.setType(1);
		for (int i = 0; i < 15; i++) {
			userlist.add(user1);
		}
		String key, value;
		for (User user : userlist) {
			Map<String, String> data = new HashMap<>();
			key = "id";
			value = Integer.toString(user.getID());
			data.put(key, value);
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
			key = "currentTime";
			value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getCurrentTime());
			data.put(key, value);
			formattedDatas.add(data);
		}
		datas.setTotal(15);
		datas.setRows(formattedDatas);
		
		System.out.println("total:" + userServiceImpl.getTotalNum());
		return datas;
	}

}
