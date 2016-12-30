package com.zjut.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import com.zjut.mapping.CascadeMapper;
import com.zjut.pojo.CascadeEntity;
import com.zjut.service.CityCascadeService;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月23日 下午2:16:47
 */
@Service("cityCascadeServiceImpl")
public class CityCascadeServiceImpl implements CityCascadeService{
	
	@Resource
	private SqlSessionTemplate sessionTemplate;

	@Override
	public List<CascadeEntity> getProvinceList() {
		CascadeMapper mapper = sessionTemplate.getMapper(CascadeMapper.class);
		List<String> entity = mapper.getProvinceList();
		return toCascadeEntity(entity);
	}

	@Override
	public List<CascadeEntity> getCityList(Map map) {
		CascadeMapper mapper = sessionTemplate.getMapper(CascadeMapper.class);
		List<String> entity = mapper.getCityList(map);
		return toCascadeEntity(entity);
	}

	@Override
	public List<CascadeEntity> getDistrictList(Map map) {
		CascadeMapper mapper = sessionTemplate.getMapper(CascadeMapper.class);
		List<String> entity = mapper.getDistrictList(map);
		return toCascadeEntity(entity);
	}

	@Override
	public List<CascadeEntity> getStreetList(Map map) {
		CascadeMapper mapper = sessionTemplate.getMapper(CascadeMapper.class);
		List<String> entity = mapper.getStreetList(map);
		return toCascadeEntity(entity);
	}

	@Override
	public List<CascadeEntity> getLocationList(Map map) {
		CascadeMapper mapper = sessionTemplate.getMapper(CascadeMapper.class);
		List<String> entity = mapper.getLocationList(map);
		return toCascadeEntity(entity);
	}
	
	private List<CascadeEntity> toCascadeEntity(List<String> list){
		List<CascadeEntity> entity = new ArrayList<CascadeEntity>();
		int i=1;
		for(String str: list){
			CascadeEntity e = new CascadeEntity(i,str);
			i++;
			entity.add(e);
		}
		return entity;
	}
	
	

}
