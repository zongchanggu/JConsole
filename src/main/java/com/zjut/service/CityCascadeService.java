package com.zjut.service;

import java.util.List;
import java.util.Map;

import com.zjut.pojo.CascadeEntity;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月23日 下午2:13:45
 */
public interface CityCascadeService {

	public List<CascadeEntity> getProvinceList();
	
	public List<CascadeEntity> getCityList(Map map);
	
	public List<CascadeEntity> getDistrictList(Map map);
	
	public List<CascadeEntity> getStreetList(Map map);
	
	public List<CascadeEntity> getLocationList(Map map);
}
