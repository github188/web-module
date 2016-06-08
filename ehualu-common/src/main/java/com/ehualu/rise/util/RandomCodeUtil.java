package com.ehualu.rise.util;


/**
 * 校验码生成类
 * 
 * @author liming
 * 
 */
public class RandomCodeUtil {
	// 校验码长度
	private final static int CODE_LENGTH = 6;

	public static String getRandomCode() {
		String code = "";
		for (int i = 0; i < CODE_LENGTH; i++) {
			code += (int) Math.round(Math.random() * 9);
		}
		return code;
	}
}
