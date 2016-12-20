package com.zjut.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.zjut.mapping.AdMapper;
import com.zjut.pojo.DevToAd;
import com.zjut.service.AdService;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月20日 下午2:38:17
 */
@Service("adServiceImpl")
public class AdServiceImpl implements AdService {

	@Resource
	private SqlSessionTemplate sessionTemplate;

	@Override
	public void updateAdStatusBatch(List<DevToAd> adForUpdate) {
		AdMapper mapper = sessionTemplate.getMapper(AdMapper.class);
		mapper.updateAdStatusBatch(adForUpdate);
	}

	@Override
	public void updateAdStatus(int AdId, int status) {
		AdMapper mapper = sessionTemplate.getMapper(AdMapper.class);
		mapper.updateAdStatus(AdId, status);
	}

}
