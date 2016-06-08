package com.ehualu.rise.pojo.msg;

import java.io.Serializable;

/**
 * 加密体
 * @author Administrator
 *
 */
public class SecurityMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private byte[] digest;//摘要密文
	
	private String signature;//数字签名

	public byte[] getDigest() {
		return digest;
	}

	public void setDigest(byte[] digest) {
		this.digest = digest;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	
}
