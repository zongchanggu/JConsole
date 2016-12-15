package com.zjut.controller;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zjut.netty.task.HealthCheckThread;
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
	public static CountDownLatch latch = new CountDownLatch(1);

	@RequestMapping("doHealthCheck")
	@ResponseBody
	public String doHealthCheck() {
		HealthCheckThread target = new HealthCheckThread();
		Thread thread = new Thread(target);
		thread.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString("success");
	}

	@RequestMapping("putAds")
	public String putAds(int dev_id) {
		List<Advertise> ads = devServiceImpl.getAdByDevID(dev_id);
		return "index";
	}
}
