package com.ctcc.xfxt2.util;

import java.security.MessageDigest;

public class NetMd5 {

	public static String GetMD5(String message) {
		String md5 = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(message.getBytes("utf-8"));
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; i++) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
			}
			md5 = sb.toString();
		} catch (Exception e) {
		}
		return md5;
	}

	public static byte[] GetByteMD5(String message) {
		byte[] md5 = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md5 = md.digest(message.getBytes("utf-8"));
		} catch (Exception e) {
		}
		return md5;
	}

}
