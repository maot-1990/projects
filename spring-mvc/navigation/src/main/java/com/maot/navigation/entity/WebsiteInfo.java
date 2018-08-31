package com.maot.navigation.entity;

import java.util.Date;

import com.pers.util.annotation.Table;

@Table(value = "WEBSITE_INFO")
public class WebsiteInfo {

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
	 * 网站名
	 */
	private String name;
	/**
	 * 网站地址
	 */
	private String webSite;
	/**
	 * 网站类别
	 */
	private String type;
	/**
	 * 日点击量
	 */
	private Integer dailyHits;
	/**
	 * 总点击量
	 */
	private Integer countHits;
	/**
	 * 小图标
	 */
	private String smallImageUrl;
	/**
	 * 大图标
	 */
	private String bigImageUrl;
	/**
	 * 推荐位 1-推荐
	 */
	private String featuredFirst;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 状态 0：未启用   1：启用
	 */
	private String status;
	
	public WebsiteInfo(){}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getDailyHits() {
		return dailyHits;
	}

	public void setDailyHits(Integer dailyHits) {
		this.dailyHits = dailyHits;
	}

	public Integer getCountHits() {
		return countHits;
	}

	public void setCountHits(Integer countHits) {
		this.countHits = countHits;
	}

	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

	public String getBigImageUrl() {
		return bigImageUrl;
	}

	public void setBigImageUrl(String bigImageUrl) {
		this.bigImageUrl = bigImageUrl;
	}

	public String getFeaturedFirst() {
		return featuredFirst;
	}

	public void setFeaturedFirst(String featuredFirst) {
		this.featuredFirst = featuredFirst;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
