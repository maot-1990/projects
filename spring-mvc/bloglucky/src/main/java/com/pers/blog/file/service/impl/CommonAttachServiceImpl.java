package com.pers.blog.file.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pers.blog.bean.CommonAttach;
import com.pers.blog.file.dao.CommonAttachDao;
import com.pers.blog.file.service.CommonAttachService;
import com.pers.blog.util.JpegImagerHandleUtils;
import com.pers.util.uuid.UuidUtil;

@Service
public class CommonAttachServiceImpl implements CommonAttachService{

	@Resource
	private CommonAttachDao commonAttachDao;
	@Value("${uploadPath}")
	private String uploadPath;

	public void saveCommonAttach(CommonAttach attach) {
		commonAttachDao.insert(attach);
		
	}

	public CommonAttach getCommonAttachById(String fileId) {
		return commonAttachDao.selectByPrimaryKey(fileId);
	}

	public String saveUploadImg(MultipartFile fileData) {
		InputStream in = null;
		OutputStream os = null;
		try {
			String path = "";
			byte[] bytes = fileData.getBytes();
			in = new ByteArrayInputStream(bytes);
			Calendar cal = Calendar.getInstance(); 
			int mon = cal.get(Calendar.DAY_OF_MONTH);
			path = uploadPath + File.separator + mon;
					
			File file = new File(path);
			if(!file.exists()){
				file.mkdir();
			}
			//保存图片到指定文件夹
			String fileName = System.currentTimeMillis()+""+fileData.getOriginalFilename().substring(fileData.getOriginalFilename().indexOf("."));
			path += File.separator + fileName;
			os = new FileOutputStream(path);
			IOUtils.copy(in, os);
			in.close();
			os.close();
			
			double fileSize = Long.valueOf(fileData.getSize()/1024).doubleValue();
			//压缩图片
			Map<String, Object> map = new HashMap<String, Object>();
			try {
				map = JpegImagerHandleUtils.compressImg(path);
				if("true".equals(map.get("success"))){
					fileSize = Double.valueOf(String.valueOf(map.get("fileSize"))).doubleValue();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			//保存图片信息到数据库
			CommonAttach attach = new CommonAttach();
			attach.setId(UuidUtil.getUuid());
			attach.setCreateTime(new Date());
			attach.setCreateUser("system");
			attach.setFileName(fileName);
			attach.setFileSize(fileSize);
			attach.setFileType(fileData.getOriginalFilename().substring(fileData.getOriginalFilename().indexOf(".")));
			attach.setPath(path);
			commonAttachDao.insert(attach);

			return attach.getId();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
