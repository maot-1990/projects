package com.pers.blog.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pers.blog.grab.GrabUrlContentUtil;

@Controller()
@RequestMapping("/sysCon")
public class SystemController {

	@Resource
	private GrabUrlContentUtil grabUrlContentUtil;

	/**
	 * 抓去开心一刻内容
	 */
	@RequestMapping("/grabJoke")
	@ResponseBody
	public Map<String, Object> grabJoke() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 1; i < 7483; i++) {
						final String url = "http://www.haha365.com/joke/index_" + i
								+ ".htm";
						new Thread(new Runnable() {
							@Override
							public void run() {
								
								grabUrlContentUtil.getUrlContent(url);
								System.out.println("当前线程处理的url:" + url);
								
							}
						}).start();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("success", "true");
		map.put("msg", "抓去笑话成功");
		return map;
	}
}
