package com.zjut.service.impl;

import java.util.List;

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
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User result = userMapper.selectByPrimaryKey(userId);
		session.close();
		return result;
	}
	@Override
	public List<User> getPageUserListByFL(int firstrow, int lastrow) {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> result = userMapper.getPageUserListByFL(firstrow, lastrow);
		session.close();
		return result;
	}
	@Override
	public int getTotalNum() {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper =session.getMapper(UserMapper.class);
		int result = userMapper.getTotalNum();
		session.close();
		return result;
	}

}
