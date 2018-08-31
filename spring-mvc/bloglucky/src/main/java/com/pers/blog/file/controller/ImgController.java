package com.pers.blog.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pers.blog.bean.CommonAttach;
import com.pers.blog.file.service.CommonAttachService;

@Controller
@RequestMapping("/img")
public class ImgController {

	@Resource
	private CommonAttachService commonAttachService;

	@RequestMapping("/uploadImg")
	@ResponseBody
	private Map<String, Object> uploadImg(MultipartFile fileData) {
		Map<String, Object> map = new HashMap<String, Object>();
		//保存上传的图片
		String fileId = commonAttachService.saveUploadImg(fileData);
		map.put("fileId", fileId);
		return map;
	}

	@RequestMapping("/showImg")
	public void showImg(HttpServletResponse response, String fileId) {
		CommonAttach attach = commonAttachService.getCommonAttachById(fileId);
		if(attach == null){
			return;
		}
		File file = new File(attach.getPath());
		if (!file.exists()) {
			new RuntimeException("文件丢失");
		}
		try {
			InputStream in = new FileInputStream(file);
			byte[] bytes = IOUtils.toByteArray(in);
			response.setHeader("Content-Type", "image/jped");// 设置响应的媒体类型，这样浏览器会识别出响应的是图片
			response.setContentType("image/jpg");
			response.getOutputStream().write(bytes);
			response.flushBuffer();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
