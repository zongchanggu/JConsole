package com.zjut.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.zjut.mapping.UserMapper;
import com.zjut.pojo.User;
import com.zjut.service.IUserService;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService{
	
	@Resource
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public User getUserById(int userId) {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		User result = userMapper.selectByPrimaryKey(userId);
		return result;
	}
	
	@Override
	public User getUserByUsernameAndPas(String username, String password) {
		// TODO Auto-generated method stub
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		User result = userMapper.getUserByUsernameAndPas(username, password);
		return result;
	}
	
	@Override
	public List<User> getPageUserListByFL(int firstrow, int lastrow) {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		List<User> result = userMapper.getPageUserListByFL(firstrow, lastrow);
		return result;
	}
	@Override
	public int getTotalNum() {
		UserMapper userMapper =sessionTemplate.getMapper(UserMapper.class);
		int result = userMapper.getTotalNum();
		return result;
	}
	@Override
	public List<User> searchPageUserList(int firstrow, int lastrow, String username, String phone, String usertype) {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		List<User> result = userMapper.searchPageUserList(firstrow, lastrow, username, phone, usertype);
		return result;
	}

	@Override
	public User getUserInfoByAdID(int id) {
		UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);
		User result = userMapper.getUserInfoByAdID(id);
		return result;
	}

}
