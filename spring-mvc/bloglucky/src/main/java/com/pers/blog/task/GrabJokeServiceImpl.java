package com.pers.blog.task;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.pers.blog.bean.ArticleInfo;
import com.pers.blog.grab.GrabUrlContentUtil;
import com.pers.blog.view.service.ArticleInfoService;

public class GrabJokeServiceImpl {
	private Logger log = Logger.getLogger(GrabJokeServiceImpl.class);
	@Resource
	private GrabUrlContentUtil grabUrlContentUtil;
	@Resource
	private ArticleInfoService articleInfoService;
	
	public void work(){
		log.info("执行笑话数据同步开始");
		//每天更新两天笑话,取出不可用的数据，更新为可用数据
		List<ArticleInfo> infos = articleInfoService.getArticleInfos(4, 0, 2);
		for(ArticleInfo info : infos){
			info.setCreateTime(new Date());
			info.setIsUse("1");
			articleInfoService.update(info);
		}
		log.info("执行笑话数据同步结束");
	}
}
