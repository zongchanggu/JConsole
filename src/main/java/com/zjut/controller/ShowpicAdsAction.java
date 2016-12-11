package com.zjut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adsAction")
public class ShowpicAdsAction {

	@RequestMapping("/showPicAds")
	public String showPicAds(){
		String viewName = "/adsPages/picAdShow";
		return viewName;
	}
	
}
