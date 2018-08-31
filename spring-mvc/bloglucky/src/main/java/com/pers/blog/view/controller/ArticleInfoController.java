package com.pers.blog.view.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.pers.blog.bean.ArticleInfo;
import com.pers.blog.bean.ReplyInfo;
import com.pers.blog.info.service.FirendLinkService;
import com.pers.blog.system.service.LeaveMessageService;
import com.pers.blog.system.service.ReplyInfoService;
import com.pers.blog.system.service.SystUserService;
import com.pers.blog.util.Pager;
import com.pers.blog.util.SerachParam;
import com.pers.blog.view.service.ArticleInfoService;
import com.pers.blog.vo.MessageBoardVo;

@Controller
@RequestMapping("/article")
public class ArticleInfoController {
	@Resource
	private ArticleInfoService articleInfoService;
	@Resource
	private LeaveMessageService leaveMessageService;
	@Resource
	private ReplyInfoService replyInfoService;
	
	/**
	 * 文章详细
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/detail")
	public String infoDetail(Pager pager, String id, HttpServletRequest request, String detail){
		//更新文章阅读数+1
		if(StringUtils.isBlank(detail)){
			articleInfoService.updateArticleInfoReadCount(id);
		}
		ArticleInfo articleInfo = articleInfoService.getArticleInfoById(id);
		
		//获取评论
		SerachParam param = new SerachParam();
		param.setType("2");
		param.setMsgId(articleInfo.getId());
		pager.setPageSize(5);
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
		request.setAttribute("articleInfo", articleInfo);
		request.setAttribute("page", page);
		request.setAttribute("pager", pager);
		
		return "infodiffusion/infoDetail";
	}
	
	/**
	 * 文章详细
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/heart")
	@ResponseBody
	public Map<String, Object> heart(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		//更新文章点赞数+1
		articleInfoService.updateArticleInfoHeartCount(id);
		map.put("success", "true");
		return map;
	}
	
}
