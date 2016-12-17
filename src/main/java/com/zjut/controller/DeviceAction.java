package com.zjut.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjut.pojo.Device;
import com.zjut.pojo.JsonDataInfo;
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
	public JsonDataInfo<Device> ajaxGetDevJson() {
		JsonDataInfo<Device> devsJson = new JsonDataInfo<>();
		List<Device> devs = devServiceImpl.getDevInfo();
		devsJson.setRows(devs);
		devsJson.setTotal(devs.size());
		return devsJson;
	}

}
