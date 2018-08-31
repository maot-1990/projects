package com.pers.mq.entity;

import java.io.Serializable;

public class MessageObject implements Serializable{

	private static final long serialVersionUID = 1L;

	public Object obj;

	public MessageObject() {}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "MessageObject [obj=" + obj + "]";
	}

}
