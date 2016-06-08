package com.ehualu.rise.service.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.pojo.Head;
import com.ehualu.rise.pojo.log.LoginLog;
import com.ehualu.rise.pojo.user.User;
import com.ehualu.rise.service.ServiceInterface;
import com.ehualu.rise.service.log.LoginLogService;
import com.ehualu.rise.service.user.UserService;
import com.ehualu.rise.util.DateUtil;
import com.ehualu.rise.web.SessionContext;

public class LogoutManager implements ServiceInterface{

	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	@Inject
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private LoginLogService loginLogService;

	public LoginLogService getLoginLogService() {
		return loginLogService;
	}
	@Inject
	public void setLoginLogService(LoginLogService loginLogService) {
		this.loginLogService = loginLogService;
	}
	@Override
	public Map<String, Object> handle(String head, String body) {
		Head header = JSON.parseObject(head, Head.class);
		if (body == null) {
			header.setZtm(AppConstant.ExecuteFlag.BODY_IS_NULL);
			return formatResult(header, null);
		}

		User usr = JSON.parseObject(body, User.class);
		try {
			//清除session
//			HttpSession session = SessionContext.getSession(usr.getPhone());
//			session.invalidate();
//			SessionContext.removeSession(usr.getPhone());
			
			
			userService.updateUserLoginStatus(usr.getPhone(),
					AppConstant.USERLOG_STATE_LOGOUT);
			LoginLog record = new LoginLog();
			record.setPhone(usr.getPhone());
			record.setMac(usr.getMac());
			record.setMfrs(usr.getMfrs());
			record.setModel(usr.getModel());
			record.setOptTime(DateUtil.getTimestamp());
			record.setAction(AppConstant.USERLOG_STATE_LOGOUT);
			loginLogService.insertLoginLog(record);
			

		} catch (Exception e) {
			e.printStackTrace();
			header.setZtm(AppConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			return formatResult(header, null);
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
