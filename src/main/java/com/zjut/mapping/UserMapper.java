package com.zjut.mapping;

import java.util.List;

import com.zjut.pojo.User;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月14日 上午00:04:20
 */
public interface UserMapper {
	public User selectByPrimaryKey(int userId);
	
	public List<User> getPageUserListByFL(int firstrow, int lastrow);
	
	public int getTotalNum();
}
