package com.pers.blog.thirdPart.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ThirdInfoData {
	
	@Value("${qqAPPID}")
	private String qqAPPID;
	@Value("${qqAPPKey}")
	private String qqAPPKey;
	
	public static String qqAccessTokenUrl="https://graph.qq.com/oauth2.0/token";
	public static String qqOpenIdUrl="https://graph.qq.com/oauth2.0/me";
	public static String qqGetUserInfoUrl="https://graph.qq.com/user/get_user_info";
	
	public static String redirect_uri="http://www.maotbbk.com/bloglucky/qqback";
	
	static{
		
	}
	
	public ThirdInfoData(){}

	public String getQqAPPID() {
		return qqAPPID;
	}

	public void setQqAPPID(String qqAPPID) {
		this.qqAPPID = qqAPPID;
	}

	public String getQqAPPKey() {
		return qqAPPKey;
	}

	public void setQqAPPKey(String qqAPPKey) {
		this.qqAPPKey = qqAPPKey;
	}
	
}	
