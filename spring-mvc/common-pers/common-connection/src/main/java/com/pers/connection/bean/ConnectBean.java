package com.pers.connection.bean;

import java.sql.Connection;

/**
 * 数据库连接池缓存对象
 * @author maot
 *
 */
public class ConnectBean {
	
	/**
	 * 创建时点的时间戳
	 */
	private long createTime;
	/**
	 * 连接保存的毫秒数
	 */
	private long keepTime=60000;
	/**
	 * 数据库连接对象
	 */
	private Connection con;
	
	public ConnectBean(){
		
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getKeepTime() {
		return keepTime;
	}

	public void setKeepTime(long keepTime) {
		this.keepTime = keepTime;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

}
