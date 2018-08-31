package com.pers.blog.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pers.blog.bean.ReplyInfo;
import com.pers.blog.system.dao.ReplyInfoDao;
import com.pers.blog.system.service.ReplyInfoService;

@Service
public class ReplyInfoServiceImpl implements ReplyInfoService{
	
	@Resource
	private ReplyInfoDao replyInfoDao;

	public void saveReplyInfo(ReplyInfo info) {
		replyInfoDao.insert(info);
		
	}

	public List<ReplyInfo> getReplyInfoListByMsgId(String id) {
		return replyInfoDao.getReplyInfoListByMsgId(id);
	}

	public void updateGlyphiconThumbs(Integer type, String id) {
		replyInfoDao.updateGlyphiconThumbs(type, id);
	}
	
	
}
