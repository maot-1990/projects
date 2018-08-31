package com.pers.connection.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.pers.connection.bean.ConnectBean;

public class ConnectionPool{

	private static Logger log = Logger.getLogger(ConnectionPool.class);
	
	private static String driverClassName;
	private static String username;
	private static String password;
	private static String url;
	private static Integer connectionCount = 1;
	//可用的连接
	private static List<ConnectBean> available = new ArrayList<ConnectBean>();
	//使用中的连接
	private static List<ConnectBean> used = new ArrayList<ConnectBean>();
	
	static{
		try {
			System.out.println("------初始化数据连接池------");
			Properties pro = new Properties();
			String path = ConnectionPool.class.getResource("/").getPath() + "properties/jdbcCon.properties";
			InputStream in = new FileInputStream(new File(path));
			pro.load(in);
			driverClassName = pro.getProperty("driverClassName");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			url = pro.getProperty("url");
			//初始化数据库连接数大小
			if(pro.containsKey("connectionCount")){
				connectionCount = Integer.valueOf(pro.getProperty("connectionCount"));
			}
			in.close();
			
			//初始化连接数
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void init(){
		try {
			Class.forName(driverClassName);
			log.info("初始化数据库连接数，共计：" + connectionCount);
			System.out.println("初始化数据库连接数，共计：" + connectionCount);
			for(int i=0; i<connectionCount; i++){
				Connection con = DriverManager.getConnection(url, username, password);
				ConnectBean conBean = new ConnectBean();
				conBean.setCon(con);
				conBean.setCreateTime(System.currentTimeMillis());
				available.add(conBean);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy(){
		System.out.println("--------销毁中-------");
		if(available != null && available.size() > 0){
			for(ConnectBean conBean : available){
				try {
					log.info("关闭数据连接");
					System.out.println("关闭数据连接");
					if(conBean.getCon() != null){
						conBean.getCon().close();
					}
				} catch (SQLException e) {
					System.out.println("关闭数据连接异常：" + e);
					log.error("关闭数据连接异常：" + e);
					e.printStackTrace();
				}
			}
		}
		log.info("关闭数据连接结束");
		System.out.println("关闭数据连接结束");
	}


	public static String getDriverClassName() {
		return driverClassName;
	}

	public static void setDriverClassName(String driverClassName) {
		ConnectionPool.driverClassName = driverClassName;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		ConnectionPool.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		ConnectionPool.password = password;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		ConnectionPool.url = url;
	}

	public static Integer getConnectionCount() {
		return connectionCount;
	}

	public static void setConnectionCount(Integer connectionCount) {
		ConnectionPool.connectionCount = connectionCount;
	}

	public static List<ConnectBean> getAvailable() {
		return available;
	}

	public static void setAvailable(List<ConnectBean> available) {
		ConnectionPool.available = available;
	}

	public static List<ConnectBean> getUsed() {
		return used;
	}

	public static void setUsed(List<ConnectBean> used) {
		ConnectionPool.used = used;
	}

	
}
