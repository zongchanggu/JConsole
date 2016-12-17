package com.zjut.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjut.pojo.Advertise;
import com.zjut.pojo.Device;
import com.zjut.pojo.JsonDataInfo;
import com.zjut.service.DevService;

import redis.clients.jedis.JedisPool;

/**
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月14日 下午9:06:32
 */

@Controller
@RequestMapping("AdsManage")
public class AdvertiseAction {
	@Resource
	private DevService devServiceImpl;
	@Resource
	private JedisPool jedisPool;

	@RequestMapping("getList")
	public String getAdList() {
		String viewName = "/adsPages/ad_list";
		return viewName;
	}

	@RequestMapping("getAdsList")
	@ResponseBody
	public JsonDataInfo<Advertise> ajaxGetAdsJson(){
		JsonDataInfo<Advertise> adsJson = new JsonDataInfo<Advertise>();
		List<Advertise> ads = devServiceImpl.getAdByDevID(1);
		adsJson.setRows(ads);
		adsJson.setTotal(ads.size());
		return adsJson;
	}
	

}
