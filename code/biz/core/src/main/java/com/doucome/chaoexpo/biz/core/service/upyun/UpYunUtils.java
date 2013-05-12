package com.doucome.chaoexpo.biz.core.service.upyun;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.doucome.chaoexpo.biz.core.enums.HttpMethodEnums;

public class UpYunUtils {
	
	private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	/**
	 * MD5 加密方法
	 * 
	 * @param str
	 *            待加密字符串 return 加密后字符串;
	 */
	public static String md5(String str) {
		
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage());
		}
		md5.update(str.getBytes());
		byte[] encodedValue = md5.digest();
		int j = encodedValue.length;
		char finalValue[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
			byte encoded = encodedValue[i];
			finalValue[k++] = hexDigits[encoded >> 4 & 0xf];
			finalValue[k++] = hexDigits[encoded & 0xf];
		}
		
		return new String(finalValue);
	}

	public static String md5(byte[] buf) throws Exception{
		
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
				
			md5.update(buf, 0, buf.length);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} 

		byte[] encodedValue = md5.digest();
		
		int j = encodedValue.length;
		char finalValue[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
			byte encoded = encodedValue[i];
			finalValue[k++] = hexDigits[encoded >> 4 & 0xf];
			finalValue[k++] = hexDigits[encoded & 0xf];
		}
		
		return new String(finalValue);
	}

		
	/**
	* 获取 GMT 格式时间戳
	* return String;
	*/
	public static String getGMTDate(Date date){
		SimpleDateFormat formater = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);  
		formater.setTimeZone(TimeZone.getTimeZone("GMT"));
		return formater.format(date);
	}
	
	
   /**
	* 连接签名方法
	* @param conn 连接
	* @param uri 请求地址
	* @param length 请求所发Body数据长度
	* return 签名字符串
	*/
	public static String sign(HttpMethodEnums method, String date ,  String uri, long length , String username , String md5Password){
		String sign = method.getValue() + "&" + uri + "&" + date + "&" + length + "&" + md5Password;
		//System.out.println(sign);
		//System.out.println("UpYun " + username + ":" + md5(sign));
		return "UpYun " + username + ":" + md5(sign);
	}
	
	public static byte[] inputStream2Buf(InputStream ins , int length) throws Exception {
		
		byte[] content = new byte[length];
		int offset = 0 ;
		int bufsize = 4096 ;
		while(true){
			int readsize = ins.read(content,offset , bufsize) ;
			offset += readsize ;
			if(offset >= length){
				break ;
			}
			if(readsize == -1){
				break ;
			}
		}
		return content ;
	}
	
	
}
