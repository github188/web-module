package com.ehualu.rise.service.log;

import java.sql.Timestamp;

import com.ehualu.rise.pojo.log.LoginLog;

public interface LoginLogService {
	/**
	 * 记录用户登录登出日志
	 * @param log
	 * @return
	 */
	public int insertLoginLog(LoginLog record);
	
	
	public Timestamp findLastLoginTime(String phone);
}
