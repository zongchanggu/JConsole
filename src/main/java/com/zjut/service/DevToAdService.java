package com.zjut.service;

import java.util.List;
import com.zjut.pojo.DevToAd;
import com.zjut.pojo.Page;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月22日 下午6:05:11
 */
public interface DevToAdService {

	public List<DevToAd> getAdsByDevID(Page p);

	public int getTotalNum();

}
