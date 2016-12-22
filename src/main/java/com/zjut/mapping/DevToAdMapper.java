package com.zjut.mapping;

import java.util.List;
import com.zjut.pojo.DevToAd;
import com.zjut.pojo.Page;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月22日 下午5:34:55
 */

public interface DevToAdMapper {

	public List<DevToAd> getAdsByDevID(Page p);
	
	public int getTotalNum();

}
