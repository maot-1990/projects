package com.pers.blog.system.dao;

import org.apache.ibatis.annotations.Param;

import com.pers.blog.bean.SystemInfo;

public interface SystemInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(SystemInfo record);

    int insertSelective(SystemInfo record);

    SystemInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemInfo record);

    int updateByPrimaryKey(SystemInfo record);
    
    /**
	 * 更新访问量
	 * @param ip 访问ip+1
	 * @param times 访问总次数+1
	 */
	public void updateSystemInfoVisitTimes(@Param("ip") String ip, @Param("times") String times, @Param("id") String id);
}