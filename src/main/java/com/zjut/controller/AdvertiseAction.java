package com.zjut.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjut.pojo.Advertise;
import com.zjut.pojo.JsonDataInfo;
import com.zjut.pojo.Page;
import com.zjut.service.AdService;
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
	private AdService adServiceImpl;
	
	@Resource
	private JedisPool jedisPool;

	@RequestMapping("getList")
	public String getAdList() {
		String viewName = "/adsPages/ad_list";
		return viewName;
	}

	/**
	 * 得到分页的广告数据
	 * alter by chenzq 12/21
	 * @param page
	 * @param rows
	 * @param adName
	 * @param dateStart
	 * @param dateEnd
	 * @param adtype
	 * @return
	 */
	@RequestMapping("getAdsList")
	@ResponseBody
	public JsonDataInfo<Advertise> ajaxGetAdsJson(int page, int rows, String adName, Date dateStart, Date dateEnd, String adtype){
		JsonDataInfo<Advertise> adsJson = new JsonDataInfo<Advertise>();
		Page p = new Page();
		p.setStart((page - 1) * rows);
		p.setEnd(page * rows);
		List<Advertise> advertises;
		if ((adName==null) && (dateStart==null) && (dateEnd==null) && (adtype==null)) {//非搜索
			advertises = adServiceImpl.getPageAdListByFL(p);
			adsJson.setTotal(adServiceImpl.getTotalNum());
			adsJson.setRows(advertises);
		}else{//点击广告页面上的搜索按钮进行搜索
			
		}
//		List<Advertise> ads = devServiceImpl.getAdByDevID(1);
//		adsJson.setRows(ads);
//		adsJson.setTotal(ads.size());
		return adsJson;
	}
	

}
