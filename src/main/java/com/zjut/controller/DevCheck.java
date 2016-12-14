package com.zjut.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zjut.pojo.Advertise;
import com.zjut.service.DevService;

/**
 * <p>
 * @author:zongchnaggu
 * </p>
 * <p>
 * @description:created by gu
 * </p>
 * <p>
 * @date:2016年12月13日
 * </p>
 */
@Controller
@RequestMapping("devCheck")
public class DevCheck {
	@Resource
	private DevService devServiceImpl;

	@RequestMapping("doHealthCheck")
	public String doHealthCheck() {

		return "index";
	}

	@RequestMapping("putAds")
	public String putAds(int dev_id) {
		List<Advertise> ads = devServiceImpl.getAdByDevID(dev_id);
		return "index";
	}
}
