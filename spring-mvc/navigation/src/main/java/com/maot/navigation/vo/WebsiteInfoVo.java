package com.maot.navigation.vo;

import java.util.ArrayList;
import java.util.List;

import com.maot.navigation.entity.WebsiteInfo;

public class WebsiteInfoVo {

	private String pType;
	private String pName;
	private List<WebsiteInfo> websiteInfos = new ArrayList<WebsiteInfo>();
	
	public WebsiteInfoVo(){}
	
	public WebsiteInfoVo(String pType, String pName,
			List<WebsiteInfo> websiteInfos) {
		this.pType = pType;
		this.pName = pName;
		this.websiteInfos = websiteInfos;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public List<WebsiteInfo> getWebsiteInfos() {
		return websiteInfos;
	}

	public void setWebsiteInfos(List<WebsiteInfo> websiteInfos) {
		this.websiteInfos = websiteInfos;
	}
	
	
}
