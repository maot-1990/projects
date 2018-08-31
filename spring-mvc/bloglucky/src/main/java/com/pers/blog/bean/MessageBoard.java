package com.pers.blog.bean;

import java.util.Date;

public class MessageBoard {
    private String id;

    private Date createTime;

    private String userName;
    
    /**
     * 留言或评论用户的id
     */
    private String userId;

    private Date updateTime;
    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论文章的id
     */
    private String msgId;

    private Integer praise;
    
    private Integer tread;
    /**
     * 1：留言    2：文章评论
     */
    private String type;
    /**
     * 是否可用
     */
    private String isUse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse == null ? null : isUse.trim();
    }

	public Integer getTread() {
		return tread;
	}

	public void setTread(Integer tread) {
		this.tread = tread;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
}