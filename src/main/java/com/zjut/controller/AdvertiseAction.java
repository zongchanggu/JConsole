package com.zjut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月14日 下午9:06:32
 */

@Controller
@RequestMapping("AdsManage")
public class AdvertiseAction {

	@RequestMapping("getList")
	public String getAdList() {
		String viewName = "/adsPages/ad_list";
		return viewName;
	}

}
