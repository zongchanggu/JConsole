package com.zjut.service;

import java.util.List;

import com.zjut.pojo.Advertise;
import com.zjut.pojo.Device;

public interface DevService {

	public Device getDevInfoByKey(int dev_id);

	public Device getDevInfoByAddress(String address);

	public Device getDevInfoByXY(String AddressXY);

	public List<Device> getDevInfo();

	public List<Advertise> getAdByDevID(int dev_id);

}
