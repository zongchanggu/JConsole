package com.zjut.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.zjut.mapping.UserToAdMapper;
import com.zjut.pojo.Page;
import com.zjut.pojo.UserToAd;
import com.zjut.service.UserToAdService;
@Service("userToAdServiceImpl")
public class UserToAdServiceImpl implements UserToAdService{
	@Resource
	private SqlSessionTemplate sessionTemplate;

	@Override
	public List<UserToAd> getAdsByUserId(Page p) {
		UserToAdMapper mapper = sessionTemplate.getMapper(UserToAdMapper.class);
		List<UserToAd> uta = mapper.getAdsByUserId(p);
		return uta;
	}

	@Override
	public int getTotalNum(int userID) {
		UserToAdMapper mapper = sessionTemplate.getMapper(UserToAdMapper.class);
		int num = mapper.getTotalNum(userID);
		return num;
	}

}
