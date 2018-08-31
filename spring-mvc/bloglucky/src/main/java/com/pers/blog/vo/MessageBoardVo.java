package com.pers.blog.vo;

import java.util.Date;
import java.util.List;

import com.pers.blog.bean.ReplyInfo;

public class MessageBoardVo {
    private String id;

    private Date createTime;

    private String userName;
    
    private String userId;

    private Date updateTime;

    private String content;

    private String msgId;

    private Long praise;
    
    private Long tread;

    private String type;

    private String isUse;
    
    private String headImgUrl;
    
    private List<ReplyInfo> replys;

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

    public Long getPraise() {
        return praise;
    }

    public void setPraise(Long praise) {
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

	public Long getTread() {
		return tread;
	}

	public void setTread(Long tread) {
		this.tread = tread;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public List<ReplyInfo> getReplys() {
		return replys;
	}

	public void setReplys(List<ReplyInfo> replys) {
		this.replys = replys;
	}
	
}