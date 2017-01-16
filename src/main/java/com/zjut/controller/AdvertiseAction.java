package com.zjut.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjut.pojo.AdSearchParam;
import com.zjut.pojo.Advertise;
import com.zjut.pojo.AdvertiseForDetail;
import com.zjut.pojo.DevToAd;
import com.zjut.pojo.JsonDataInfo;
import com.zjut.pojo.Page;
import com.zjut.pojo.User;
import com.zjut.pojo.UserToAd;
import com.zjut.service.AdService;
import com.zjut.service.DevService;
import com.zjut.service.DevToAdService;
import com.zjut.service.IUserService;
import com.zjut.service.UserToAdService;

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
	@Resource
	private IUserService userServiceImpl;

	@RequestMapping("getList")
	public String getAdList() {
		String viewName = "/adsPages/ad_list";
		return viewName;
	}


	/**
	 * created by zongchnaggu
	 * @param id
	 * @param page
	 * @param rows
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

	/**
	 * 得到分页的广告数据 created by chenzq 12/29
	 * 
	 * @param page
	 * @param rows
	 * @param adName
	 * @param dateStart
	 * @param dateEnd
	 * @param adtype
	 * @return
	 */
	@RequestMapping("getPageAdsList")
	@ResponseBody
	public JsonDataInfo<Advertise> getPageAdsList(int page, int rows, String adName, Date dateStart, Date dateEnd,
			String adtype) {
		JsonDataInfo<Advertise> adsJson = new JsonDataInfo<Advertise>();
		Page p = new Page();
		p.setStart((page - 1) * rows);
		p.setEnd(page * rows);
		List<Advertise> advertises;
		if ((adName == null) && (dateStart == null) && (dateEnd == null) && (adtype == null)) {// 非搜索
			advertises = adServiceImpl.getPageAdListByFL(p);
			adsJson.setTotal(adServiceImpl.getTotalNum());
			adsJson.setRows(advertises);
		} else {// 点击广告页面上的搜索按钮进行搜索
			AdSearchParam param = new AdSearchParam();
			param.setPageParams(p);
			param.setAdName(adName);
			param.setDateEnd(dateEnd);
			param.setDateStart(dateStart);
			param.setAdType(adtype);
			advertises = adServiceImpl.searchPageAdList(param);
			adsJson.setTotal(advertises.size());
			adsJson.setRows(advertises);
		}
		// List<Advertise> ads = devServiceImpl.getAdByDevID(1);
		// adsJson.setRows(ads);
		// adsJson.setTotal(ads.size());
		return adsJson;
	}
	
	/**
	 * 根据广告id得到广告详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getAdDetail", method = { RequestMethod.POST })
	public ModelAndView getAdDetail(int id){
		ModelAndView mView = new ModelAndView();
		
		//首先根据广告id以及usertoad, user表获取该广告所属的用户信息
		User userinfo = userServiceImpl.getUserInfoByAdID(id);
		mView.addObject("userinfo", userinfo);
		
		//接着根据广告id以及usertoad, advertise表获取广告的详细信息
		AdvertiseForDetail adDetail = adServiceImpl.getAdInfoByAdId(id);
		//System.out.println(adDetail.getResieterTime());
		mView.addObject("adInfo", adDetail);
		
		//根据广告类型，准备要展示的广告媒体文件的文件名，供前端获取并展示
		String showFileNames = adDetail.getUploadPath();
		String pathPrefixStr = showFileNames.substring(0, showFileNames.lastIndexOf("/")+1);
		//System.out.println(pathPrefixStr);
		mView.addObject("pathPrefix", pathPrefixStr);
		showFileNames = showFileNames.substring(showFileNames.lastIndexOf("/")+1);
		//System.out.println(showFileNames);
		if("图片".equals(adDetail.getType().getComment())){
			String[] picNames = showFileNames.split(",");
			mView.addObject("picNames", picNames);
		}
		if("视频".equals(adDetail.getType().getComment())){
			String videoName = showFileNames;
			mView.addObject("videoName", videoName);
		}
		
		String viewName = "/adsPages/adDetail";
		mView.setViewName(viewName);
		return mView;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
