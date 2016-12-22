package com.zjut.service;

import java.util.List;
import com.zjut.pojo.Page;
import com.zjut.pojo.UserToAd;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月22日 下午7:51:46
 */
public interface UserToAdService {

	public List<UserToAd> getAdsByUserId(Page p);
	
	public int getTotalNum(int userID);
}
