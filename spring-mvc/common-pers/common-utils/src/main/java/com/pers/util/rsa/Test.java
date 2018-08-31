package com.pers.util.rsa;

import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.util.Base64Utils;

public class Test {
	
	public static void main(String[] args) throws Exception{
		String keyStorePath = "H:\\work\\tomcat\\keystore\\tomcat.keystore";
		String certPath = "H:\\work\\tomcat\\keystore\\tomcat.cer";
		KeyStore keyStore = CertUtils.getKeyStore(keyStorePath, "maot123");
		System.out.println(keyStore);
		PublicKey publicKey = CertUtils.getPublicKey(certPath);
		System.out.println(publicKey);
		PrivateKey privateKey = CertUtils.getPrivateKey(keyStorePath, "tomcat", "maot123");
		System.out.println(privateKey);
		Certificate cert = CertUtils.getCertificate(certPath);
		//System.out.println(cert);
		
		String data = "safsfaewffafregtrewygwgfd—@#qewfrewq75&qw@3safasfdsewrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrfsddddddddddddddddddddddddddddddddaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvaf";
		System.out.println("加密串长度：" + data.length());
		//生成摘要信息
		byte[] signData = CertUtils.sign(data.getBytes(), keyStorePath, "tomcat", "maot123");
		System.out.println("生成摘要信息:" + new String(Base64Utils.encode(signData)));
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sign", new String(Base64Utils.encode(signData)));
		paramMap.put("body", data);
		System.out.println("paramMap:" + paramMap);
		JSONObject json = JSONObject.fromObject(paramMap);
		System.out.println("json:" + json);
		//私钥加密
		byte[] enData = CertUtils.encryptByPrivateKey(json.toString().getBytes(), keyStorePath, "tomcat", "maot123");
		String dataBase64 = new String(Base64Utils.encode(enData));
		System.out.println(dataBase64);
		//公钥解密
		//byte[] deDataBase64 = Base64Utils.decode(dataBase64.getBytes());
		//System.out.println(new String(deDataBase64));
		byte[] deData = CertUtils.decryptByPublicKey(enData, certPath);
		System.out.println(new String(deData));
		//验签
		JSONObject jsonResult = JSONObject.fromObject(new String(deData));
		String signResult = jsonResult.getString("sign");
		String bodyResult = jsonResult.getString("body");
		boolean signResultEn = CertUtils.verifySign(bodyResult.getBytes(), signResult, certPath);
		System.out.println("验签结果：" + signResultEn);
		//------------------------------------
		String data2 = "s234afsfaewffafregtrewygwgfd—@#qewfrewq75&qw@3safasfdsewrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrfsddddddddddddddddddddddddddddddddaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvaf";
		//公钥加密
		byte[] enData2 = CertUtils.encryptByPublicKey(data2.getBytes(), certPath);
		System.out.println(Base64Utils.encode(enData2));
		//私钥解密
		byte[] deData2 = CertUtils.decryptByPrivateKey(enData2, keyStorePath, "tomcat", "maot123");
		System.out.println(new String(deData2));
		
		
		
	}
	
	

}
