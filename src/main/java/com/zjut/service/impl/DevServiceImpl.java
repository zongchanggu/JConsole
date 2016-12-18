package com.zjut.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.zjut.mapping.DevMapper;
import com.zjut.pojo.Advertise;
import com.zjut.pojo.Device;
import com.zjut.pojo.Page;
import com.zjut.pojo.SearchEntity;
import com.zjut.service.DevService;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月13日 下午11:10:28
 */
public class DevServiceImpl implements DevService {
	@Resource
	private SqlSessionTemplate sessionTemplate;

	@Override
	public Device getDevInfoByKey(int dev_id) {
		return null;
	}

	@Override
	public Device getDevInfoByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Device getDevInfoByXY(String AddressXY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> getDevInfo(Page p) {
		DevMapper mapper = sessionTemplate.getMapper(DevMapper.class);
		List<Device> devs = mapper.getDevInfo(p);
		return devs;
	}

	@Override
	public List<Advertise> getAdByDevID(int dev_id) {
		DevMapper devMapper = sessionTemplate.getMapper(DevMapper.class);
		return devMapper.getAdByDevID(dev_id);
	}

	@Override
	public Device getDevDetail(int devID) {
		DevMapper devMapper = sessionTemplate.getMapper(DevMapper.class);
		return devMapper.getDevDetail(devID);
	}

	@Override
	public void insertDevInfo(Device device) {
		DevMapper devMapper = sessionTemplate.getMapper(DevMapper.class);
		devMapper.insertDevInfo(device);
	}

	@Override
	public void deleteDevsInfo(int[] ids) {
		DevMapper devMapper = sessionTemplate.getMapper(DevMapper.class);
		devMapper.deleteDevsInfo(ids);
	}

	@Override
	public Integer getTotal() {
		DevMapper devMapper = sessionTemplate.getMapper(DevMapper.class);
		Integer total = devMapper.getTotal();
		return total;
	}

	@Override
	public List<Device> searchDevInfoByCondition(SearchEntity entity) {
		DevMapper devMapper = sessionTemplate.getMapper(DevMapper.class);
		List<Device> devs = devMapper.searchDevInfoByCondition(entity);
		return devs;
	}

}
