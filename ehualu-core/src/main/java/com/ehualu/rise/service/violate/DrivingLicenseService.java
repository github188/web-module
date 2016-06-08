package com.ehualu.rise.service.violate;

import com.ehualu.rise.pojo.msg.Msg;

/**
 * 驾驶证信息接口
 * @author Administrator
 *
 */
public interface DrivingLicenseService {

	/**
	 * 通过身份证明号码查询驾驶证信息
	 * @param paramJson
	 * @return
	 */
	public Msg queryLicenseBySfzmhm(String paramJson);
	
	/**
	 * 通过身份证明号码查询加密驾驶证信息
	 * @param paramJson
	 * @return
	 */
	public Msg queryEnLicenseBySfzmhm(String paramJson);
}
