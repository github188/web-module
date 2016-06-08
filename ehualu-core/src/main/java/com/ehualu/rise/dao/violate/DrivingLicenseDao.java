package com.ehualu.rise.dao.violate;

import com.ehualu.rise.pojo.violate.DrivingLicense;
import com.ehualu.rise.pojo.violate.DrivingLicenseEn;

/**
 * 驾驶证Dao接口
 * @author Administrator
 *
 */
public interface DrivingLicenseDao {

	/**
	 * 通过身份证明号码查询驾驶证信息
	 * @param drivingLicense
	 * @return
	 */
	public DrivingLicense queryLicenseBySfzmhm(DrivingLicense drivingLicense);
	
	/**
	 * 通过身份证明号码查询加密的驾驶证信息
	 * @param drivingLicenseEn
	 * @return
	 */
	public DrivingLicenseEn queryEnLicenseBySfzmhm(DrivingLicenseEn drivingLicenseEn);
}
