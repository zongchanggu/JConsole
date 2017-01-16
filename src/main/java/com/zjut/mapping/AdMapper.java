package com.zjut.mapping;

import java.util.List;

import com.zjut.pojo.AdSearchParam;
import com.zjut.pojo.Advertise;
import com.zjut.pojo.AdvertiseForDetail;
import com.zjut.pojo.DevToAd;
import com.zjut.pojo.Page;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月14日 上午00:03:42
 */
public interface AdMapper {

	public void updateAdStatusBatch(List<DevToAd> adForUpdate);
	
	public void updateAdStatus(int AdID,int status);
	
	public List<Advertise> getPageAdListByFL(Page p);
	
	public int getTotalNum();

	public List<Advertise> searchPageAdList(AdSearchParam param);
	
	public AdvertiseForDetail getAdInfoByAdId(int id);
}
