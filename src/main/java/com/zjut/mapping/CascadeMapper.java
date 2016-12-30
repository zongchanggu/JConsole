package com.zjut.mapping;

import java.util.List;
import java.util.Map;

import com.zjut.pojo.CascadeEntity;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月23日 下午2:18:26
 */
public interface CascadeMapper {
	
	public List<String> getAllList(Map map);
	
	public List<String> getProvinceList();
	
	public List<String> getCityList(Map map);
	
	public List<String> getDistrictList(Map map);
	
	public List<String> getStreetList(Map map);
	
	public List<String> getLocationList(Map map);
}
