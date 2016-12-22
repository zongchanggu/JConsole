package com.zjut.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import com.zjut.mapping.DevToAdMapper;
import com.zjut.pojo.DevToAd;
import com.zjut.pojo.Page;
import com.zjut.service.DevToAdService;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月22日 下午6:05:52
 */
@Service("devToAdServiceImpl")
public class DevToAdServiceImpl implements DevToAdService {

	@Resource
	private SqlSessionTemplate sessionTemplate;

	@Override
	public List<DevToAd> getAdsByDevID(Page p) {
		DevToAdMapper mapper = sessionTemplate.getMapper(DevToAdMapper.class);
		List<DevToAd> dtas = mapper.getAdsByDevID(p);
		return dtas;
	}

	@Override
	public int getTotalNum() {
		DevToAdMapper mapper = sessionTemplate.getMapper(DevToAdMapper.class);
		int num = mapper.getTotalNum();
		return num;
	}

}
