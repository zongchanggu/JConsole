package com.zjut.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjut.pojo.Advertise;
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
		List<Advertise> ads = devServiceImpl.getAdByDevID(1);
		String viewName = "/adsPages/ad_list";
		return viewName;
	}

}
