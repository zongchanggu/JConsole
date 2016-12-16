package com.zjut.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.zjut.mapping.UserMapper;
import com.zjut.pojo.User;
import com.zjut.service.IUserService;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService{
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	@Override
	public User getUserById(int userId) {
		UserMapper userMapper =sqlSessionFactory.openSession().getMapper(UserMapper.class);
		return userMapper.selectByPrimaryKey(userId);
	}
	@Override
	public List<User> getPageUserListByFL(int firstrow, int lastrow) {
		// TODO Auto-generated method stub
		UserMapper userMapper =sqlSessionFactory.openSession().getMapper(UserMapper.class);
		return userMapper.getPageUserListByFL(firstrow, lastrow);
	}
	@Override
	public int getTotalNum() {
		// TODO Auto-generated method stub
		UserMapper userMapper =sqlSessionFactory.openSession().getMapper(UserMapper.class);
		return userMapper.getTotalNum();
	}

}
