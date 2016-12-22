package com.zjut.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjut.pojo.Advertise;
import com.zjut.pojo.DevToAd;
import com.zjut.pojo.Device;
import com.zjut.pojo.JsonDataInfo;
import com.zjut.pojo.Page;
import com.zjut.pojo.UserToAd;
import com.zjut.service.AdService;
import com.zjut.service.DevService;
import com.zjut.service.DevToAdService;
import com.zjut.service.UserToAdService;

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
	private DevToAdService devToAdServiceImpl;
	@Resource
	private UserToAdService userToAdServiceImpl;

	@RequestMapping("getList")
	public String getAdList() {
		String viewName = "/adsPages/ad_list";
		return viewName;
	}

	/**
	 * 得到分页的广告数据 alter by chenzq 12/21
	 * 
	 * @param page
	 * @param rows
	 * @param adName
	 * @param dateStart
	 * @param dateEnd
	 * @param adtype
	 * @return
	 */
	@RequestMapping("getUserToAdsList")
	@ResponseBody
	public JsonDataInfo<Advertise> getUserToAdsList(int id, int page, int rows) {
		JsonDataInfo<Advertise> adsJson = new JsonDataInfo<Advertise>();
		Page p = new Page();
		p.setStart((page - 1) * rows);
		p.setEnd(page * rows);
		p.setReserve(id);
		List<UserToAd> utas = userToAdServiceImpl.getAdsByUserId(p);
		List<Advertise> ads = new ArrayList<>();
		if (utas != null && utas.size() != 0) {
			Iterator<UserToAd> it = utas.iterator();
			while (it.hasNext()) {
				UserToAd tmp = it.next();
				ads.addAll(tmp.getAds());
			}
		}
		adsJson.setRows(ads);
		int num = userToAdServiceImpl.getTotalNum(id);
		adsJson.setTotal(num);
		return adsJson;
	}

	@RequestMapping("getAdsList")
	@ResponseBody
	public JsonDataInfo<DevToAd> ajaxGetJson(int id, int page, int rows) {
		Page p = new Page();
		p.setStart((page - 1) * rows);
		p.setEnd(page * rows);
		p.setReserve(id);
		JsonDataInfo<DevToAd> dtaJson = new JsonDataInfo<>();
		List<DevToAd> dtas = devToAdServiceImpl.getAdsByDevID(p);
		int size = devToAdServiceImpl.getTotalNum();
		dtaJson.setRows(dtas);
		dtaJson.setTotal(size);
		return dtaJson;
	}

}
