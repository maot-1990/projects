package com.pers.blog.view.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.pers.blog.bean.ArticleInfo;
import com.pers.blog.util.SerachParam;

public interface ArticleInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKeyWithBLOBs(ArticleInfo record);

    public List<ArticleInfo> getArticleInfoList(@Param("type") String type, @Param("size")Integer size);
    
    public List<ArticleInfo> getHotClick(@Param("type") String type, @Param("size")Integer size);
    
    public List<ArticleInfo> getNewArticleInfo(@Param("type") String type, @Param("size")Integer size);
    
    public ArticleInfo getArticleInfoById(String id);
    
    public Page<ArticleInfo> getArticleInfoAllList(SerachParam info);
    
    public void updateArticleInfoReadCount(String id);
    
    public void updateArticleInfoHeartCount(String id);
    
    public ArticleInfo getArticleInfoDailySentent();
    
    public List<ArticleInfo> getArticleInfos(@Param("type") Integer type, @Param("isUse") Integer isUse, @Param("size") Integer size);
}