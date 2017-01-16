package com.zjut.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author chen-zhiqiang
 *
 * @version 创建时间：2017年1月3日上午10:33:38
 */
public class AdSearchParam implements Serializable {

	private static final long serialVersionUID = 1L;
	private String adName;
	private Date dateStart;
	private Date dateEnd;
	private String adType;
	private Page pageParams;

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public Page getPageParams() {
		return pageParams;
	}

	public void setPageParams(Page pageParams) {
		this.pageParams = pageParams;
	}

}
