package com.pers.util.url;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

/**
 * 消息发送函数
 * 
 * @author maot
 */
public class URLUtils {

	private static String ENCODED = "UTF-8";

	/**
	 * POST方式发送
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static String sendPost(String url, String param) throws RuntimeException{
		StringBuffer result = new StringBuffer();
		HttpURLConnection httpConn = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL httpurl = new URL(url);
			httpConn = (HttpURLConnection) httpurl.openConnection();
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			out = new PrintWriter(httpConn.getOutputStream());
			out.print(param);
			out.flush();
			out.close();
			// 采用UTF-8编码,解决中文乱码
			in = new BufferedReader(new InputStreamReader(
					httpConn.getInputStream(),ENCODED));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			in.close();
		} catch (Exception e) {
			System.out.println("post方式发送失败,URL="+url+",params="+param+e.getMessage());
			throw new RuntimeException(e);
		} finally {
			if (httpConn != null) {
				httpConn.disconnect();
			}
			if (out != null) {
				out.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result.toString();
	}

	/**
	 * GET方式发送
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static String sendGet(String url, String param) throws RuntimeException {
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		try {
			String urlName = url + "?" + param;//
			URL U = new URL(urlName);
			URLConnection connection = U.openConnection();
			//connection.setConnectTimeout(5000);
			//connection.setReadTimeout(5000);
			connection.connect();
			// 采用UTF-8编码,解决中文乱码
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), ENCODED));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			in.close();
		} catch (Exception e) {
			System.out.println("get方式发送失败,URL="+url+",params="+param+e.getMessage());
			throw new RuntimeException(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result.toString();
	}

	/**
	 * GET方式发送
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static InputStream sendGetToInputStream(String url, String param) throws RuntimeException{
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		try {
			String urlName = url + "?" + param;//
			URL U = new URL(urlName);
			URLConnection connection = U.openConnection();
			connection.connect();
			// 采用UTF-8编码,解决中文乱码
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), ENCODED));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			in.close();
			return new ByteArrayInputStream(result.toString().getBytes());
		} catch (Exception e) {
			System.err.println("get方式发送失败,URL="+url+",params="+param+e.getMessage());
			throw new RuntimeException(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * POST方式发送
	 * @param url
	 * @param param
	 * @return
	 */
	public static InputStream sendPostToInputStream(String url, String param) throws RuntimeException{
		StringBuffer result = new StringBuffer();
		HttpURLConnection httpConn = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL httpurl = new URL(url);
			httpConn = (HttpURLConnection) httpurl
					.openConnection();
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			out = new PrintWriter(httpConn.getOutputStream());
			out.print(param);
			out.flush();
			out.close();
			// 采用UTF-8编码,解决中文乱码
			in = new BufferedReader(new InputStreamReader(
					httpConn.getInputStream(),ENCODED));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			in.close();
			return new ByteArrayInputStream(result.toString().getBytes());
		} catch (Exception e) {
			System.err.println("post方式发送失败,URL="+url+",params="+param+e.getMessage());
			throw new RuntimeException(e);
		} finally {
			if (httpConn != null) {
				httpConn.disconnect();
			}
			if (out != null) {
				out.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * httpClient post发送json
	 * @author Mosnter
	 * @param url
	 * @param json
	 * @return
	 */
	public static JSONObject post(String url, String json) {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		JSONObject response = null;
		try {
			StringEntity s = new StringEntity(json);
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			post.setEntity(s);
			HttpResponse res = client.execute(post);
			if (res.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = res.getEntity();
				String result = EntityUtils.getContentCharSet(entity);
				response = JSONObject.fromObject(result);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}
	
	/**
	 * 获取用户真实IP
	 *
	 * @author cnpayd 
	 * @param request
	 * @return
	 */
	public static String getRealIp(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;
    }
}
