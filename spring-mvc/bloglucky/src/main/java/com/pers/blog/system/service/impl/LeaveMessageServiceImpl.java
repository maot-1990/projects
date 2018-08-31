package com.pers.blog.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pers.blog.bean.MessageBoard;
import com.pers.blog.system.dao.MessageBoardDao;
import com.pers.blog.system.service.LeaveMessageService;
import com.pers.blog.util.Pager;
import com.pers.blog.util.SerachParam;
import com.pers.blog.vo.MessageBoardVo;

@Service
public class LeaveMessageServiceImpl implements LeaveMessageService{

	@Resource
	private MessageBoardDao messageBoardDao;
	
	public List<MessageBoard> getLeaveMessage() {
		return messageBoardDao.getLeaveMessage();
	}

	public Page<MessageBoardVo> getLeaveMessage(Pager pager, SerachParam param) {
		PageHelper.startPage(pager.getPageIndex(), pager.getPageSize());
		Page<MessageBoardVo> page = messageBoardDao.getLeaveMessagePage(pager, param);
		pager.setPageIndex(page.getPageNum());
		pager.setPageSize(page.getPageSize());
		pager.setTotalPage(page.getPages());
		pager.setTotalNum(Long.valueOf(page.getTotal()).intValue());
		return page;
	}

	public void updateGlyphiconThumbs(Integer type, String id) {
		
	    messageBoardDao.updateGlyphiconThumbs(type, id);
	}

	public void saveMessage(MessageBoard board) {
		messageBoardDao.insert(board);
	}
	
	
}
