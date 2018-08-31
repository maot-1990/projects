package com.maot.navigation.entity;

import java.util.Date;

import com.pers.util.annotation.Table;

@Table(value="WEBSITE_TYPE")
public class WebsiteType {

	
	/**
	 * 主键
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
	 * 类型名称
	 */
	private String name;
	/**
	 * 类型编码
	 */
	private String type;
	/**
	 * 子类编码
	 */
	private String pType;
	/**
	 * 子类类型名称
	 */
	private String pName;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 状态 0：未启用   1：启用
	 */
	private String status;
	
	public WebsiteType(){}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
