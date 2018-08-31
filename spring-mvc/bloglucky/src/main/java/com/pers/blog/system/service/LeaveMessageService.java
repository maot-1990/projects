package com.pers.blog.system.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.pers.blog.bean.MessageBoard;
import com.pers.blog.util.Pager;
import com.pers.blog.util.SerachParam;
import com.pers.blog.vo.MessageBoardVo;

public interface LeaveMessageService {

	public List<MessageBoard> getLeaveMessage();
	
	public Page<MessageBoardVo> getLeaveMessage(Pager pager, SerachParam param);
	
	public void updateGlyphiconThumbs(Integer type, String id);
	
	public void saveMessage(MessageBoard board);
}
