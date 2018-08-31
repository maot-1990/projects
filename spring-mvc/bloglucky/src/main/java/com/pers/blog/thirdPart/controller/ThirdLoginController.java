package com.pers.blog.thirdPart.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pers.blog.bean.SystUser;
import com.pers.blog.system.service.SystUserService;
import com.pers.blog.thirdPart.util.ThirdInfoData;
import com.pers.blog.util.UserUtils;
import com.pers.util.url.URLUtils;
import com.pers.util.uuid.UuidUtil;

/**
 * 第三方用户登录的回调地址
 * @author maot
 *
 */
@Controller
public class ThirdLoginController {
	
	private Logger log = Logger.getLogger(ThirdLoginController.class);
	
	@Resource
	private ThirdInfoData thirdInfoData;
	@Resource
	private SystUserService systUserService;
	
	/**
	 * qq回调地址
	 * @param code
	 * @param respone
	 * @param request
	 */
	@RequestMapping("/qqback")
	public void qqback(String code, HttpServletResponse response, HttpServletRequest request){
		log.info("qq回调返回的code:" + code);
		try {
			if(StringUtils.isNotBlank(code)){
				String tokenData = URLUtils.sendGet(ThirdInfoData.qqAccessTokenUrl, 
						"grant_type=authorization_code&client_id="+thirdInfoData.getQqAPPID()+
						"&client_secret="+thirdInfoData.getQqAPPKey()+"&code="+code+"&redirect_uri="+
						ThirdInfoData.redirect_uri);
				log.info("获取token:" + tokenData);
				Map<String, Object> tokenMap = handleToMap(tokenData);
				if(tokenMap != null){
					String token = tokenMap.get("access_token").toString();
					
					String openIdData = URLUtils.sendGet(ThirdInfoData.qqOpenIdUrl, 
							"access_token="+token);
					JSONObject openIdJson = JSONObject.fromObject(openIdData.replaceAll("callback\\( ", "").replaceAll(" \\);", ""));
					
					String openid = openIdJson.getString("openid");
					
					String userInfoJson = URLUtils.sendGet(ThirdInfoData.qqGetUserInfoUrl, 
							"access_token="+token+"&oauth_consumer_key="+thirdInfoData.getQqAPPID()+"&openid="+openid);
					JSONObject userJson = JSONObject.fromObject(userInfoJson);
					
					//保存之前先查询该用户是否登录过
					SystUser user = systUserService.selectSystUserByQQOpenId(openid);
					if(user == null){//保存用户信息
						user = new SystUser();
						user.setId(UuidUtil.getUuid());
						user.setCreateTime(new Date());
						user.setUpdateTime(new Date());
						user.setAddress(userJson.getString("province")+"~"+userJson.getString("province"));
						user.setAge(Integer.valueOf(userJson.getString("year")));
						user.setUserName(userJson.getString("nickname"));
						user.setQqOpenid(openid);
						user.setSex(userJson.getString("gender"));
						user.setStatus("1");
						user.setHeadImgUrl(userJson.getString("figureurl_qq_1"));
						systUserService.saveSystUser(user);
					}else{//更新用户信息
						user.setAddress(userJson.getString("province")+"~"+userJson.getString("province"));
						user.setAge(Integer.valueOf(userJson.getString("year")));
						user.setUserName(userJson.getString("nickname"));
						user.setQqOpenid(openid);
						user.setSex(userJson.getString("gender"));
						user.setUpdateTime(new Date());
						user.setHeadImgUrl(userJson.getString("figureurl_qq_1"));
						systUserService.updateSystUserByQQOpenId(user);
					}
					
					UserUtils.put(request.getSession(), user);
					request.getSession().setAttribute("user", user);
					log.info("获取用户的信息:"+userInfoJson);
				}
				
			}
			
			
			response.sendRedirect(request.getContextPath()+"/success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将形如a=b&c=d变换为map
	 * @param str
	 * @return
	 */
	public Map<String, Object> handleToMap(String str){
		try {
			if(str == null){
				return null;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			String[] data = str.split("&");
			for(int i=0; i<data.length; i++){
				String[] value = data[i].split("=");
				map.put(value[0], value[1]);
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/success")
	public String success(){
		return "thirdinfo/success";
	}
	
	public static void main(String[] args) {
		String s = "callback( {\"client_id\":\"101378446\",\"openid\":\"B0376B0CC0E7A162255D58827045DA58\"} );";
		System.out.println(s.replaceAll("callback\\( ", "").replaceAll(" \\);", ""));
	}
}
