package com.pers.blog.system.service;

import java.util.List;

import com.pers.blog.bean.ReplyInfo;

public interface ReplyInfoService {
	
	public void saveReplyInfo(ReplyInfo info);
	
	public List<ReplyInfo> getReplyInfoListByMsgId(String id);
	
	public void updateGlyphiconThumbs(Integer type, String id);
}
