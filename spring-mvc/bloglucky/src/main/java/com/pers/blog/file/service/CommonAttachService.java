package com.pers.blog.file.service;

import org.springframework.web.multipart.MultipartFile;

import com.pers.blog.bean.CommonAttach;

public interface CommonAttachService {

	public void saveCommonAttach(CommonAttach attach);
	
	public CommonAttach getCommonAttachById(String fileId);
	
	public String saveUploadImg(MultipartFile fileData);
}
