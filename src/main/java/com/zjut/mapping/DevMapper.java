package com.zjut.mapping;

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
 * @date:2016年12月14日 上午00:03:54
 */
public interface DevMapper {

	public List<DevToAd> getAdByDevID(int dev_id);

	public List<Integer> getDevIds();

	public List<Device> getDevInfo(Page p);

	public Device getDevDetail(int devId);

	public void insertDevInfo(Device device);

	public void deleteDevsInfo(int[] ids);

	public Integer getTotal();

	public List<Device> searchDevInfoByCondition(SearchEntity entity);

	public List<Device> getDevsAddressXY(String cityName);

}
