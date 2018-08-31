package com.pers.blog.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.pers.blog.bean.MessageBoard;
import com.pers.blog.util.Pager;
import com.pers.blog.util.SerachParam;
import com.pers.blog.vo.MessageBoardVo;


public interface MessageBoardDao {
    int deleteByPrimaryKey(String id);

    int insert(MessageBoard record);

    int insertSelective(MessageBoard record);

    MessageBoard selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MessageBoard record);

    int updateByPrimaryKey(MessageBoard record);
    
    public List<MessageBoard> getLeaveMessage();
    
    public Page<MessageBoardVo> getLeaveMessagePage(Pager pager,@Param("param") SerachParam param);
    
    public void updateGlyphiconThumbs(@Param("type") Integer type, @Param("id") String id);
    
}