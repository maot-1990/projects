package com.maot.navigation.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.pers.util.enums.CommonType;

/**
 * 全局的exception异常处理
 * 
 * @author maot
 *
 */
@Component
public class BaseExceptionHandler implements HandlerExceptionResolver {

	public static Logger log = Logger.getLogger(BaseExceptionHandler.class);

	@SuppressWarnings("static-access")
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception excep) {
		ModelAndView model = new ModelAndView();
		
		try {
			Map<String, Object> exceMap = new HashMap<String, Object>();
			exceMap.put("code", CommonType.responseType.unknown_error.getCode());
			exceMap.put("msg", excep.getMessage());

			response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 设置ContentType
			response.setCharacterEncoding("UTF-8"); // 避免乱码
			response.setHeader("Cache-Control", "no-cache, must-revalidate");

			JSONObject json = new JSONObject();
			response.getWriter().write(json.fromObject(exceMap).toString());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("捕获异常：" + e);
		}

		return model;
	}

}
