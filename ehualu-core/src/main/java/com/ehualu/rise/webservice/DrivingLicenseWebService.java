package com.ehualu.rise.webservice;
/**
 * 驾驶证查询
 * @author Administrator
 *
 */
public interface DrivingLicenseWebService {

	/**
	 * 通过身份证明号码查询驾驶证信息
	 * @param paramJson
	 * @return
	 */
	public String queryLicenseBySfzmhm(String paramJson);
	
	/**
	 * 通过身份证明号码查询加密驾驶证信息
	 * @param paramJson
	 * @return
	 */
	public String queryEnLicenseBySfzmhm(String paramJson);
}
