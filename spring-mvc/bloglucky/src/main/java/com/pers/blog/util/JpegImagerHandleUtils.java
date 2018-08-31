package com.pers.blog.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.coobird.thumbnailator.Thumbnails;

public class JpegImagerHandleUtils {
	/**
	 * 
	 * @Description:生成缩略图
	 * @param imageFile
	 *            图片文件
	 * @param request
	 *            请求对象
	 * @param uploadPath
	 *            上传目录
	 * @return
	 */
	public static Map<String, Object> compressImg(String filePath) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (filePath == null) {
			map.put("success", "false");
			map.put("msg", "压缩文件不能为空");
			return map;
		}
		try {
			Thumbnails.of(filePath).scale(1f).outputQuality(0.5).toFile(filePath);
			File file = new File(filePath);
			map.put("fileSize", file.length()/1024);
		} catch (Exception e) {
			map.put("success", "false");
			map.put("msg", e.getMessage());
			return map;
		}
		map.put("success", "true");
		map.put("msg", "压缩成功");
		return map;
	}

	public static void main(String[] args) {
		compressImg("D:\\c0.jpg");
	}
}
