package com.zjut.mapping;

import java.util.List;

import com.zjut.pojo.DevToAd;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月14日 上午00:03:42
 */
public interface AdMapper {

	public void updateAdStatusBatch(List<DevToAd> adForUpdate);
	
	public void updateAdStatus(int AdID,int status);

}
