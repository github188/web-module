package com.ehualu.rise.service.violate;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.pojo.Head;
import com.ehualu.rise.pojo.user.UserDriverLicense;
import com.ehualu.rise.pojo.violate.DrivingLicense;
import com.ehualu.rise.service.ServiceInterface;
import com.ehualu.rise.service.user.UserDriverLicenseService;

public class UnBoundDrivingLicenseManage implements ServiceInterface{
	private static final Logger logger = Logger
			.getLogger(UnBoundDrivingLicenseManage.class);
	
	private UserDriverLicenseService userDriverLicenseService;

	public UserDriverLicenseService getUserDriverLicenseService() {
		return userDriverLicenseService;
	}
	@Inject
	public void setUserDriverLicenseService(
			UserDriverLicenseService userDriverLicenseService) {
		this.userDriverLicenseService = userDriverLicenseService;
	}
	@Override
	public Map<String, Object> handle(String head, String body) {
		Head header = JSON.parseObject(head, Head.class);
		if (body == null) {
			header.setZtm(AppConstant.ExecuteFlag.BODY_IS_NULL);
			return formatResult(header, null);
		}
		DrivingLicense drivingLicense = JSON.parseObject(body, DrivingLicense.class);
		UserDriverLicense userDriverLicense = JSON.parseObject(body, UserDriverLicense.class);
		userDriverLicense.setZjhm(drivingLicense.getSfzmhm());
		
		try {
			//用户名为空
			if(userDriverLicense.getUsername()==null || "".equals(userDriverLicense.getUsername())){
				header.setZtm(AppConstant.Code_04.USERNAME_IS_NULL);
				return formatResult(header,null);
			}
			//身份证号码为空
			if(drivingLicense.getSfzmhm() == null || "".equals(drivingLicense.getSfzmhm())){
			    header.setZtm(AppConstant.Code_04.LICENSE_SFZMHM_IS_NULL);
			    return formatResult(header,null);
			}
			int n = userDriverLicenseService.unboundUserDriverLicense(userDriverLicense);
			if(n==0){
				header.setZtm(AppConstant.Code_04.INFO_NOT_MATCH);
			    return formatResult(header,null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			header.setZtm(AppConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			return formatResult(header,null);
		}
		return formatResult(header, null);
	}

	@Override
	public Map<String, Object> formatResult(Object head, Object object) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(AppConstant.HEAD, head);
		if (object != null) {
			map.put(AppConstant.BODY, object);
		}

		return map;
	}
}
