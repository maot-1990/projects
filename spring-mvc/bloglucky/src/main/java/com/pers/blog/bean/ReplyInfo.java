package com.pers.blog.bean;

import java.util.Date;

public class ReplyInfo {
    private String rId;

    private Date rcreateTime;

    private Date rupdateTime;
    /**
     * 是否有效
     */
    private String risUse;
    /**
     * MessageBoard的主键
     */
    private String rmsgId;
    /**
     * 回复的内容
     */
    private String rcontent;
    /**
     * 赞
     */
    private Integer rpraise;
    /**
     * 踩
     */
    private Integer rtread;
    /**
     * 回复的用户id
     */
    private String ruserId;
    
    private String ruserName;
    
    /**
     * 不为数据库字段，只是存回复用户的头像路径
     */
    private String headImgUrl;
    /**
     * 被回复的用户id
     */
    private String buserId;
    
    private String buserName;
    
    

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public Date getRcreateTime() {
		return rcreateTime;
	}

	public void setRcreateTime(Date rcreateTime) {
		this.rcreateTime = rcreateTime;
	}

	public Date getRupdateTime() {
		return rupdateTime;
	}

	public void setRupdateTime(Date rupdateTime) {
		this.rupdateTime = rupdateTime;
	}

	public String getRisUse() {
		return risUse;
	}

	public void setRisUse(String risUse) {
		this.risUse = risUse;
	}

	public String getRmsgId() {
		return rmsgId;
	}

	public void setRmsgId(String rmsgId) {
		this.rmsgId = rmsgId;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public Integer getRpraise() {
		return rpraise;
	}

	public void setRpraise(Integer rpraise) {
		this.rpraise = rpraise;
	}

	public Integer getRtread() {
		return rtread;
	}

	public void setRtread(Integer rtread) {
		this.rtread = rtread;
	}

	public String getRuserId() {
		return ruserId;
	}

	public void setRuserId(String ruserId) {
		this.ruserId = ruserId;
	}

	public String getRuserName() {
		return ruserName;
	}

	public void setRuserName(String ruserName) {
		this.ruserName = ruserName;
	}

	public String getBuserId() {
		return buserId;
	}

	public void setBuserId(String buserId) {
		this.buserId = buserId;
	}

	public String getBuserName() {
		return buserName;
	}

	public void setBuserName(String buserName) {
		this.buserName = buserName;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	
}