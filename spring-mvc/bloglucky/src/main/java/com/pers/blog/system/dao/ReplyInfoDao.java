package com.pers.blog.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pers.blog.bean.ReplyInfo;


public interface ReplyInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(ReplyInfo record);

    int insertSelective(ReplyInfo record);

    ReplyInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReplyInfo record);

    int updateByPrimaryKey(ReplyInfo record);
    
    public List<ReplyInfo> getReplyInfoListByMsgId(String id);
    
	public void updateGlyphiconThumbs(@Param("type") Integer type, @Param("id") String id);

}