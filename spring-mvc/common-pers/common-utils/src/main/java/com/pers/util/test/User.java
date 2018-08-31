package com.pers.util.test;

import java.util.Date;

@com.pers.util.annotation.Test(value="hehe",name={com.pers.util.enums.Test.black,com.pers.util.enums.Test.red})
public class User {

	public String id;
	private String name;
	private String pwd;
	private String sex;
	private String address;
	private Date createTime;
	
	public User(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", sex="
				+ sex + ", address=" + address + ", createTime=" + createTime
				+ "]";
	}

	
	
}
