package com.maot.navigation.entity;

import java.util.Date;

import com.pers.util.annotation.Table;

/**
 * 用户收藏的网址
 * @author maot
 *
 */
@Table(value="USER_WEBSITE_INFO")
public class UserWebsiteInfo {

	/**
	 * 主键id
	 */
	private String id;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 网站名称
	 */
	private String webName;
	/**
	 * 网站地址
	 */
	private String webSite;
	/**
	 * 标签
	 */
	private String label;
	/**
	 * 排序
	 */
	private String sort;
	/**
	 * 状态 0:失效  1：生效
	 */
	private String status;
	
	private UserWebsiteInfo(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
