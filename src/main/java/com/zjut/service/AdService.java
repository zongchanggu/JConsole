package com.zjut.service;

import java.util.List;

import com.zjut.pojo.AdSearchParam;
import com.zjut.pojo.Advertise;
import com.zjut.pojo.AdvertiseForDetail;
import com.zjut.pojo.DevToAd;
import com.zjut.pojo.Page;
public interface AdService {
	
	public void updateAdStatusBatch(List<DevToAd> adForUpdate);
	
	public void updateAdStatus(int AdId,int status);
	
	public List<Advertise> getPageAdListByFL(Page p);
	
	public int getTotalNum();
	
	public List<DevToAd> getAdsByDevID(Page p);
	
	public List<Advertise> searchPageAdList(AdSearchParam param);
	
	public AdvertiseForDetail getAdInfoByAdId(int id);

}
