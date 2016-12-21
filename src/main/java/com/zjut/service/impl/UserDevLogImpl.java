package com.zjut.service.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.zjut.mapping.UserDevMapper;
import com.zjut.pojo.UserDevLog;
import com.zjut.service.UserDevLogService;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月21日 下午3:17:31
 */
@Service("userDevLogImpl")
public class UserDevLogImpl implements UserDevLogService{

	@Resource
	private SqlSessionTemplate sessionTemplate;
	@Override
	public void insertOperateName(UserDevLog udl) {
		UserDevMapper mapper = sessionTemplate.getMapper(UserDevMapper.class);
		mapper.insertOperateName(udl);
	}
	
	

}
