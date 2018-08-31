package com.pers.blog.grab;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.stereotype.Component;

import com.pers.blog.bean.ArticleInfo;
import com.pers.blog.view.service.ArticleInfoService;
import com.pers.util.uuid.UuidUtil;

@Component("grabUrlContentUtil")
public class GrabUrlContentUtil {
	@Resource
	private ArticleInfoService articleInfoService;

	public String getUrlContent(String urlStr) {
		try {
			HttpClient client = new HttpClient();
			GetMethod getMethod = new GetMethod(urlStr);
			int status = client.executeMethod(getMethod);
			if(status == 200){
				System.out.println("请求地址返回状态：" + status);
				String content = new String(getMethod.getResponseBodyAsString()
						.getBytes("ISO-8859-1"), "gbk");
				getvalue(content, "<div class=\"bg_t1\"></div>",
						"<div class=\"fl\">");
			}else{
				System.out.println("失败-----请求地址返回状态：" + status);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "抓取笑话执行成功";
	}

	/**
	 * 
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	private void getvalue(String str, String start, String end) {
		String regex = start + "([.\\s\\S]*?)" + end;
		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(str);
		while (mat.find()) {
			String content = mat.group();
			String regexTitle = "<h3>" + "([.\\s\\S]*?)" + "</h3>";
			String regexContent = "<div id=\"endtext\">" + "([.\\s\\S]*?)"
					+ "</div>";

			Pattern patTitle = Pattern.compile(regexTitle);
			Matcher matTitle = patTitle.matcher(content);
			String replace = "[\\w<>=./\"]";
			String replaceIntro = "[\\w<>=.&;/\"\\s]";
			if (matTitle.find()) {
				System.out.println("匹配后的标题："
						+ matTitle.group().replaceAll(replace, ""));
			}
			Pattern patContent = Pattern.compile(regexContent);
			Matcher matContent = patContent.matcher(content);
			if (matContent.find()) {
				System.out.println("匹配后的内容：" + matContent.group());
			}
			ArticleInfo info = new ArticleInfo();
			info.setId(UuidUtil.getUuid());
			info.setCreateTime(new Date());
			info.setContent(matContent.group());
			info.setIntroduction(matContent.group().replaceAll(replaceIntro, "").replaceAll("[\\s]", "").replaceAll(" ", ""));
			info.setTitle(matTitle.group().replaceAll(replace, ""));
			info.setHeart(0);
			info.setIsUse("1");
			info.setType("4");
			info.setTypeName("开心一刻");
			info.setReadingCount(0);
			
			articleInfoService.saveArticleInfo(info);
		}
	}

	public static void main(String[] args) {

	}

}
