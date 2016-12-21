package com.zjut.service;

import java.util.List;

import com.zjut.pojo.Advertise;
import com.zjut.pojo.DevToAd;
import com.zjut.pojo.Page;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月20日 下午2:44:31
 */
public interface AdService {
	
	public void updateAdStatusBatch(List<DevToAd> adForUpdate);
	
	public void updateAdStatus(int AdId,int status);
	
	public List<Advertise> getPageAdListByFL(Page p);
	
	public int getTotalNum();

}
