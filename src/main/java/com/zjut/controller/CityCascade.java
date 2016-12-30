package com.zjut.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjut.pojo.CascadeEntity;
import com.zjut.service.CityCascadeService;

@Controller
@RequestMapping("cityCascade")
public class CityCascade {

	@Resource
	private CityCascadeService cityCascadeServiceImpl;

	@RequestMapping("getProvinceList")
	@ResponseBody
	public List<CascadeEntity> getProvinceList() {
		List<CascadeEntity> entity = cityCascadeServiceImpl.getProvinceList();
		return entity;
	}

	@RequestMapping("getCityList")
	@ResponseBody
	public List<CascadeEntity> getCityList(@RequestParam("provinceName") String provinceName) {
		Map<String, String> map = new HashMap<>();
		map.put("provinceName", provinceName);
		List<CascadeEntity> entity = cityCascadeServiceImpl.getCityList(map);
		return entity;
	}

	@RequestMapping("getDistrictList")
	@ResponseBody
	public List<CascadeEntity> getDistrictList(String provinceName, String cityName) {
		Map<String, String> map = new HashMap<>();
		map.put("provinceName", provinceName);
		map.put("cityName", cityName);
		List<CascadeEntity> entity = cityCascadeServiceImpl.getDistrictList(map);
		return entity;
	}

	@RequestMapping("getStreetList")
	@ResponseBody
	public List<CascadeEntity> getStreetList(String provinceName, String cityName, String districtName) {
		Map<String, String> map = new HashMap<>();
		map.put("provinceName", provinceName);
		map.put("cityName", cityName);
		map.put("districtName", districtName);
		List<CascadeEntity> entity = cityCascadeServiceImpl.getStreetList(map);

		return entity;
	}

	@RequestMapping(value = "getLocationList")
	@ResponseBody
	public List<CascadeEntity> getLocationList(String provinceName, String cityName, String districtName,
			String streetName) {
		Map<String, String> map = new HashMap<>();
		map.put("provinceName", provinceName);
		map.put("cityName", cityName);
		map.put("districtName", districtName);
		map.put("streetName", streetName);
		List<CascadeEntity> entity = cityCascadeServiceImpl.getLocationList(map);
		return entity;
	}

}
