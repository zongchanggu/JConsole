package com.zjut.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
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

}
