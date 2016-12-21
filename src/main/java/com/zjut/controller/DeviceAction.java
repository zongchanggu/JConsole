package com.zjut.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.zjut.annotion.Log;
import com.zjut.pojo.Advertise;
import com.zjut.pojo.DevToAd;
import com.zjut.pojo.Device;
import com.zjut.pojo.JsonDataInfo;
import com.zjut.pojo.Page;
import com.zjut.pojo.SearchEntity;
import com.zjut.service.AdService;
import com.zjut.service.DevService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月19日 下午1:04:19
 */
@Controller
@RequestMapping("DevAction")
public class DeviceAction {

	@Resource
	private DevService devServiceImpl;

	@Resource
	private AdService adServiceImpl;

	@Resource
	private JedisPool jedisPool;

	@RequestMapping("getBaiduMap")
	public String getBaiduMap() {
		return "/devsPages/baidu_map";
	}

	@RequestMapping("getDevsAddressXY")
	@ResponseBody
	@Log(operationType = "select", operationName = "根据经纬度获取设备点")
	public List<Device> getDevsAddressXY(String name) {
		name = "hz";
		List<Device> xys = devServiceImpl.getDevsAddressXY(name);
		return xys;
	}

	@RequestMapping("getDevList")
	public String getDevsList() {
		String devs_list = "/devsPages/dev_list";
		return devs_list;
	}

	@RequestMapping("getDevsDataJson")
	@ResponseBody
	@Log(operationType = "select", operationName = "获取设备列表")
	public JsonDataInfo<Device> ajaxGetDevJson(int page, int rows) {
		Page p = new Page();
		p.setStart((page - 1) * rows);
		p.setEnd(page * rows);
		JsonDataInfo<Device> devsJson = new JsonDataInfo<>();
		List<Device> devs = devServiceImpl.getDevInfo(p);
		int size = devServiceImpl.getTotal();
		devsJson.setRows(devs);
		devsJson.setTotal(size);
		return devsJson;
	}

	@RequestMapping(value = "DevDetail", method = { RequestMethod.POST })
	@Log(operationType="select",operationName="获取设备详情关联广告")
	public ModelAndView DevDetail(int devID, Model dev) {
		Device device = devServiceImpl.getDevDetail(devID);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/devsPages/dev_detail");
		mav.addObject("dev", device);
		return mav;
	}
	
	@RequestMapping("DevDetail")
	@ResponseBody
	@Log(operationType="select",operationName="获取设备详情")
	public Device DevDetail(int devID) {
		Device device = devServiceImpl.getDevDetail(devID);
		return device;
	}

	@RequestMapping("deleteDevsInfo")
	@ResponseBody
	@Log(operationType="delete",operationName="批量删除设备信息")
	public String deleteDevsInfo(@RequestParam(value = "ids[]") int[] ids) {
		devServiceImpl.deleteDevsInfo(ids);
		return "success";
	}

	@RequestMapping("deliverAds")
	@ResponseBody
	@Log(operationType="select ad whice id =2",operationName="向客户端投递广告")
	public String deliverAds(@RequestParam(value = "ids[]") int[] ids) {
		List<DevToAd> adForUpdate = new ArrayList<>();
		Jedis jedis = jedisPool.getResource();
		for (int i = 0; i < ids.length; i++) {
			List<DevToAd> ads = devServiceImpl.getAdByDevID(ids[i]);
			List<String> tmp = new ArrayList<>();
			Iterator<DevToAd> it = ads.iterator();
			int t = 0;
			while (it.hasNext()) {
				DevToAd ad = it.next();
				if (ad.getAdStatus() == 2) {
					tmp.add(ad.toString());
					adForUpdate.add(ad);
					t++;
				}
			}
			if (tmp.size() != 0 && tmp != null)
				jedis.sadd("dev_" + ids[i], tmp.toArray(new String[tmp.size()]));
		}
		if (adForUpdate != null && adForUpdate.size() != 0)
			updateAdsStatus(adForUpdate);
		return "success";
	}

	private void updateAdsStatus(List<DevToAd> adForUpdate) {
		Iterator<DevToAd> it = adForUpdate.iterator();
		while (it.hasNext()) {
			DevToAd ad = it.next();
			adServiceImpl.updateAdStatus(ad.getAdID(), ad.getAdStatus() + 1);
		}
	}

	private void updateAdStatus(List<DevToAd> adForUpdate) {
		adServiceImpl.updateAdStatusBatch(adForUpdate);
	}

	@RequestMapping("doSearchDev")
	@ResponseBody
	@Log(operationType="search",operationName="查询设备")
	public JsonDataInfo<Device> doSearch(SearchEntity entity) {
		List<Device> devs = devServiceImpl.searchDevInfoByCondition(entity);
		JsonDataInfo<Device> devsJson = new JsonDataInfo<>();
		devsJson.setRows(devs);
		devsJson.setTotal(devs.size());
		return devsJson;
	}

	@RequestMapping("insertDevInfo")
	@ResponseBody
	@Log(operationType="insert",operationName="增加新设备")
	public String insertDevInfo(Device device) {
		devServiceImpl.insertDevInfo(device);
		return "success";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
