package com.wangl.locust.util;

import java.security.MessageDigest;

public class MD5Encrypt {
	
	public final static String MD5(String s) {
		byte[] btInput = s.getBytes();
		return MD5Encrypt.MD5(btInput);
	}
	
	public final static String MD5(byte[] btInput) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
//			MessageDigest mdInst = MessageDigest.getInstance("SHA-1");  
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(MD5Encrypt.MD5("111111"));
	}
}