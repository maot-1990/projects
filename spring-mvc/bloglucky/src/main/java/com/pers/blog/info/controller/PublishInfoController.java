package com.pers.blog.info.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.pers.blog.base.controller.BaseController;
import com.pers.blog.bean.ArticleInfo;
import com.pers.blog.file.service.CommonAttachService;
import com.pers.blog.view.service.ArticleInfoService;
import com.pers.util.uuid.UuidUtil;

@Controller
@RequestMapping("/publishInfo")
public class PublishInfoController extends BaseController{
	
	@Resource
	private CommonAttachService commonAttachService;
	@Resource
	private ArticleInfoService articleInfoService;
	
	@RequestMapping("/edit.html")
	public String editInfo(){
		return "infodiffusion/createNew";
	}
	
	@RequestMapping("/edit1.html")
	public String editInfo1(){
		return "infodiffusion/createNew1";
	}
	
	@RequestMapping("/saveInfo")
	public String saveInfo(MultipartFile fileData, ArticleInfo info){
		String fileId = "";
		if(fileData.getSize() > 0){
			fileId = commonAttachService.saveUploadImg(fileData);
		}

		info.setAuthor("maot");
		info.setCreateTime(new Date());
		info.setId(UuidUtil.getUuid());
		info.setImgUrl(fileId);
		info.setReadingCount(0);
		info.setHeart(0);
		info.setIsUse("1");
		
		articleInfoService.saveArticleInfo(info);
		return "infodiffusion/createNew";
	}
}
