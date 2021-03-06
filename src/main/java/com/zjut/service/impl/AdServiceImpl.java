package com.zjut.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.zjut.mapping.AdMapper;
import com.zjut.mapping.DevToAdMapper;
import com.zjut.pojo.AdSearchParam;
import com.zjut.pojo.Advertise;
import com.zjut.pojo.AdvertiseForDetail;
import com.zjut.pojo.DevToAd;
import com.zjut.pojo.Page;
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

	@Override
	public List<Advertise> getPageAdListByFL(Page p) {
		AdMapper mapper = sessionTemplate.getMapper(AdMapper.class);
		List<Advertise> result = mapper.getPageAdListByFL(p);
		return result;
	}

	@Override
	public int getTotalNum() {
		// TODO Auto-generated method stub
		AdMapper mapper = sessionTemplate.getMapper(AdMapper.class);
		int result = mapper.getTotalNum();
		return result;
	}

	@Override
	public List<DevToAd> getAdsByDevID(Page p) {
		DevToAdMapper mapper = sessionTemplate.getMapper(DevToAdMapper.class);
		List<DevToAd> dtas = mapper.getAdsByDevID(p);
		return dtas;
	}

	@Override
	public List<Advertise> searchPageAdList(AdSearchParam param) {
		AdMapper mapper = sessionTemplate.getMapper(AdMapper.class);
		List<Advertise> result = mapper.searchPageAdList(param);
		return result;
	}

	@Override
	public AdvertiseForDetail getAdInfoByAdId(int id) {
		AdMapper mapper = sessionTemplate.getMapper(AdMapper.class);
		AdvertiseForDetail result = mapper.getAdInfoByAdId(id);
		return result;
	}

}
