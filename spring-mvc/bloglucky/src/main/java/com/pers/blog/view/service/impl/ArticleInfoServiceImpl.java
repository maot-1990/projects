package com.pers.blog.view.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pers.blog.bean.ArticleInfo;
import com.pers.blog.util.Pager;
import com.pers.blog.util.SerachParam;
import com.pers.blog.view.dao.ArticleInfoDao;
import com.pers.blog.view.service.ArticleInfoService;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {
	@Resource
	private ArticleInfoDao articleInfoDao;

	public List<ArticleInfo> getArticleInfoList(String type, Integer size) {
		return articleInfoDao.getArticleInfoList(type, size);
	}

	public List<ArticleInfo> getHotClick(String type, Integer size) {
		return articleInfoDao.getHotClick(type, size);
	}

	public List<ArticleInfo> getNewArticleInfo(String type, Integer size) {
		return articleInfoDao.getNewArticleInfo(type, size);
	}

	public ArticleInfo getArticleInfoById(String id) {
		return articleInfoDao.getArticleInfoById(id);
	}

	public Page<ArticleInfo> getArticleInfoAllList(SerachParam info,
			Pager pager) {
		PageHelper.startPage(pager.getPageIndex(), pager.getPageSize());
		Page<ArticleInfo> page = articleInfoDao.getArticleInfoAllList(info);
		pager.setPageIndex(page.getPageNum());
		pager.setPageSize(page.getPageSize());
		pager.setTotalPage(page.getPages());
		pager.setTotalNum(Long.valueOf(page.getTotal()).intValue());
		return page;
	}

	public ArticleInfo getArticleInfoDailySentent(){
		return articleInfoDao.getArticleInfoDailySentent();
	}
	
	public void saveArticleInfo(ArticleInfo info) {
		articleInfoDao.insert(info);
		
	}

	public void updateArticleInfoReadCount(String id) {
		articleInfoDao.updateArticleInfoReadCount(id);
		
	}

	public void updateArticleInfoHeartCount(String id) {
		articleInfoDao.updateArticleInfoHeartCount(id);
		
	}

	@Override
	public List<ArticleInfo> getArticleInfos(Integer type, Integer isUse,
			Integer size) {
		return articleInfoDao.getArticleInfos(type, isUse, size);
	}

	@Override
	public void update(ArticleInfo info) {
		articleInfoDao.updateByPrimaryKeySelective(info);
	}
	
	
}
