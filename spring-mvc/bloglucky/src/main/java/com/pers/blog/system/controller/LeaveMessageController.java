package com.pers.blog.system.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.pers.blog.bean.ArticleInfo;
import com.pers.blog.bean.MessageBoard;
import com.pers.blog.bean.ReplyInfo;
import com.pers.blog.bean.SystUser;
import com.pers.blog.system.service.LeaveMessageService;
import com.pers.blog.system.service.ReplyInfoService;
import com.pers.blog.system.service.SystUserService;
import com.pers.blog.util.Pager;
import com.pers.blog.util.SerachParam;
import com.pers.blog.util.UserUtils;
import com.pers.blog.view.service.ArticleInfoService;
import com.pers.blog.vo.MessageBoardVo;
import com.pers.util.uuid.UuidUtil;

@Controller
@RequestMapping("/message")
public class LeaveMessageController {

	Logger log = Logger.getLogger(LeaveMessageController.class);

	@Resource
	private LeaveMessageService leaveMessageService;
	@Resource
	private SystUserService systUserService;
	@Resource
	private ReplyInfoService replyInfoService;
	@Resource
	private ArticleInfoService articleInfoService;

	@RequestMapping("/board.html")
	public String boardInfo(HttpServletRequest request, Pager pager,
			SerachParam param) {
		pager.setPageSize(10);
		if(param == null){
			param = new SerachParam();
		}
		param.setType("1");
		Page<MessageBoardVo> page = leaveMessageService.getLeaveMessage(pager,
				param);
		// 封装留言中回复的内容
		if (page != null && page.getResult() != null) {
			for (int i = 0; i < page.getResult().size(); i++) {
				List<ReplyInfo> replys = replyInfoService
						.getReplyInfoListByMsgId(page.getResult().get(i)
								.getId());
				page.getResult().get(i).setReplys(replys);
			}
		}

		request.setAttribute("pager", pager);
		request.setAttribute("page", page);
		return "boardWords/board";
	}

	/**
	 * 留言板 赞或踩 type 1:赞 2：踩
	 * replyType 1:评论或留言  2:评论或留言的回复
	 * @return
	 */
	@RequestMapping("/glyphiconThumbs")
	@ResponseBody
	public Map<String, Object> glyphiconThumbs(Integer type, String id, String replyType) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if("1".equals(replyType)){
				leaveMessageService.updateGlyphiconThumbs(type, id);
			}else if("2".equals(replyType)){
				replyInfoService.updateGlyphiconThumbs(type, id);
			}
			
			map.put("success", "true");
			map.put("msg", "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("更新点赞功能失败：" + e);
			map.put("success", "false");
			map.put("msg", e);
			return map;
		}
		return map;
	}

	/**
	 * 保存用户的留言
	 * 
	 * @param board
	 * @return
	 */
	@RequestMapping("/saveMessage")
	@ResponseBody
	public Map<String, Object> saveMessage(HttpServletRequest request, MessageBoard board) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (StringUtils.isBlank(board.getContent())) {
				map.put("success", "false");
				map.put("msg", "留言内容不能为空！");
				return map;
			}
			board.setCreateTime(new Date());
			// 用户头像
			board.setId(UuidUtil.getUuid());
			board.setIsUse("1");
			board.setPraise(0);
			board.setTread(0);
			if(UserUtils.getUserSession().containsKey(request.getSession().getId())){
				SystUser user = UserUtils.getUserSession().get(request.getSession().getId());
				board.setUserName(user.getUserName());
				board.setUserId(user.getId());
			}else{
				map.put("success", "false");
				map.put("msg", "请先登录");
				return map;
			}
			
			leaveMessageService.saveMessage(board);
		} catch (Exception e) {
			map.put("success", "false");
			map.put("msg", e);
			e.printStackTrace();
			return map;
		}
		map.put("success", "true");
		map.put("msg", "更新成功");
		return map;
	}

	/**
	 * 回复留言和评论
	 * 
	 * @return
	 */
	@RequestMapping("/reply")
	@ResponseBody
	public Map<String, Object> replyInfo(HttpServletRequest request, ReplyInfo info) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(info.getRcontent())) {
			map.put("msg", "请填写回复内容");
			map.put("success", "false");
			return map;
		}
		info.setrId(UuidUtil.getUuid());
		info.setRcreateTime(new Date());
		info.setRisUse("1");
		info.setRpraise(0);
		info.setRtread(0);
		info.setRuserId("");
		if(UserUtils.getUserSession().containsKey(request.getSession().getId())){
			SystUser user = UserUtils.getUserSession().get(request.getSession().getId());
			info.setRuserName(user.getUserName());
			info.setRuserId(user.getId());
		}else{
			map.put("success", "false");
			map.put("msg", "请先登录");
			return map;
		}
		map.put("msg", "保存成功");
		map.put("success", "true");
		replyInfoService.saveReplyInfo(info);
		return map;
	}
}
