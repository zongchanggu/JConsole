package com.zjut.service;

import java.util.List;

import com.zjut.pojo.Advertise;
import com.zjut.pojo.DevToAd;
import com.zjut.pojo.Device;
import com.zjut.pojo.Page;
import com.zjut.pojo.SearchEntity;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月18日 下午12:57:52
 */
public interface DevService {

	public Device getDevInfoByKey(int dev_id);

	public Device getDevInfoByXY(String AddressXY);

	public List<Device> getDevInfo(Page p);

	public List<DevToAd> getAdByDevID(int dev_id);

	public Device getDevDetail(int devID);

	public void insertDevInfo(Device device);

	public void deleteDevsInfo(int[] ids);

	public Integer getTotal();

	public List<Device> searchDevInfoByCondition(SearchEntity entity);

	public List<Device> getDevsAddressXY(String cityName);

}
