package com.zjut.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * 
 * @author chen-zhiqiang
 *
 * @version 创建时间：2016年12月21日上午11:46:42
 */
public class Md5Utils {

	/**
	 * md5加密
	 * @param encodeStr 待加密的字符串
	 * @param uppercase 是否转为大写字符串
	 * @return 加密后的字符串
	 */
	public static String Md5Encode(String encodeStr, boolean uppercase){
		if(encodeStr==null)
			return null;
		
		String md5Str = null;
		MessageDigest md5Digest = null;
		
		try {
			// 获得MD5摘要对象
			md5Digest = MessageDigest.getInstance("MD5");
			sun.misc.BASE64Encoder base64en = new sun.misc.BASE64Encoder();
			
			//加密
			md5Str=base64en.encode(md5Digest.digest(encodeStr.getBytes("utf-8")));
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(Md5Utils.class).info("md5Encode exception:" + e.getStackTrace());
		}
		
		return uppercase? md5Str.toUpperCase() : md5Str;
	}
}
