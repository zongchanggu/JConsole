package com.zjut.mapping;

import java.util.List;

import com.zjut.pojo.Advertise;
import com.zjut.pojo.Device;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月14日 上午00:03:54
 */
public interface DevMapper {

	public List<Advertise> getAdByDevID(int dev_id);

	public List<Integer> getDevIds();
	
	public List<Device> getDevInfo();

}
