package com.ctcc.xfxt2.util;

/*
 * @ 功能: 随机生成密码, 密码位数可以指定
 */
import java.util.Random;

public class RandomCode {
	
	public static final String randomCheckcode(int length) {
		Random randGen = null;
		char[] numbersAndLetters = null;
		Object initLock = new Object();
		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			synchronized (initLock) {
				if (randGen == null) {
					randGen = new Random();
					numbersAndLetters = ("23456789ABCDEFGHJKLMNPRSTUVWXYZ")
							.toCharArray();
				}
			}
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(31)];
		}
		return new String(randBuffer);
	}
	
}
