package com.zjut.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.zjut.pojo.Device;
import com.zjut.pojo.JsonDataInfo;
import com.zjut.pojo.Page;
import com.zjut.pojo.SearchEntity;
import com.zjut.service.DevService;

@Controller
@RequestMapping("DevAction")
public class DeviceAction {

	@Resource
	private DevService devServiceImpl;

	@RequestMapping("getDevList")
	public String getDevsList() {
		String devs_list = "/devsPages/dev_list";
		return devs_list;
	}

	@RequestMapping("getDevsDataJson")
	@ResponseBody
	public JsonDataInfo<Device> ajaxGetDevJson(int page, int rows) {
		Page p = new Page();
		p.setStart((page-1)*rows);
		p.setEnd(page*rows);
		JsonDataInfo<Device> devsJson = new JsonDataInfo<>();
		List<Device> devs = devServiceImpl.getDevInfo(p);
		int size = devServiceImpl.getTotal();
		devsJson.setRows(devs);
		devsJson.setTotal(size);
		return devsJson;
	}

	@RequestMapping("DevDetail")
	@ResponseBody
	public Device DevDetail(int devID) {
		Device device = devServiceImpl.getDevDetail(devID);
		return device;
	}
	
	@RequestMapping("deleteDevsInfo")
	@ResponseBody
	public String deleteDevsInfo(@RequestParam(value="ids[]") int[] ids){
		devServiceImpl.deleteDevsInfo(ids);
		return "success";
	}
	
	@RequestMapping("doSearchDev")
	@ResponseBody
	public JsonDataInfo<Device> doSearch(SearchEntity entity){
		List<Device> devs = devServiceImpl.searchDevInfoByCondition(entity);
		JsonDataInfo<Device> devsJson = new JsonDataInfo<>();
		devsJson.setRows(devs);
		devsJson.setTotal(devs.size());
		return devsJson;
	}

	@RequestMapping("insertDevInfo")
	@ResponseBody
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
