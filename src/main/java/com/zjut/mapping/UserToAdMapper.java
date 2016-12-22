package com.zjut.mapping;

import java.util.List;
import com.zjut.pojo.Page;
import com.zjut.pojo.UserToAd;
/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月22日 下午7:48:08
 */
public interface UserToAdMapper {
	
	public List<UserToAd> getAdsByUserId(Page p);
	
	public int getTotalNum(int userID);

}
