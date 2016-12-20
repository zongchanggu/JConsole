package com.zjut.service;

import java.util.List;

import com.zjut.pojo.DevToAd;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月20日 下午2:44:31
 */
public interface AdService {
	
	public void updateAdStatusBatch(List<DevToAd> adForUpdate);
	
	public void updateAdStatus(int AdId,int status);

}
