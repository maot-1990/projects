package com.pers.blog.view.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.pers.blog.bean.ArticleInfo;
import com.pers.blog.util.Pager;
import com.pers.blog.util.SerachParam;


public interface ArticleInfoService {
	
	public List<ArticleInfo> getArticleInfoList(String type, Integer size);
	
	public List<ArticleInfo> getHotClick(String type, Integer size);
	
	public List<ArticleInfo> getNewArticleInfo(String type, Integer size);
	
	public ArticleInfo getArticleInfoById(String id);
	
	public Page<ArticleInfo> getArticleInfoAllList(SerachParam info, Pager pager);
	
	public void saveArticleInfo(ArticleInfo info);
	
	public void updateArticleInfoReadCount(String id);
	
	public void updateArticleInfoHeartCount(String id);
	
	public ArticleInfo getArticleInfoDailySentent();
	
	public List<ArticleInfo> getArticleInfos(Integer type, Integer isUse, Integer size);
	
	public void update(ArticleInfo info);
}
