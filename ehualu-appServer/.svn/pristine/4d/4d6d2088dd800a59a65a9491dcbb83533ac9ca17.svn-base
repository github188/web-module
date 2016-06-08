package com.ehualu.rise.service.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.page.SystemContext;
import com.ehualu.rise.pojo.Head;
import com.ehualu.rise.pojo.user.User;
import com.ehualu.rise.service.ServiceInterface;
import com.ehualu.rise.util.DateUtil;
import com.ehualu.rise.web.SessionContext;

public class RegisterManager implements ServiceInterface {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	
	@Inject
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Map<String, Object> handle(String head, String body) {
		Head header = JSON.parseObject(head, Head.class);
		if(body == null){
			header.setZtm(AppConstant.ExecuteFlag.BODY_IS_NULL);
			return formatResult(header, null);
		}
		User usr = JSON.parseObject(body, User.class);
		usr.setUsername(usr.getPhone());
		usr.setStatus(AppConstant.USER_STATE_VALID);
		usr.setCreateDate(DateUtil.getSqlDate());
		
		User user = userService.queryByUserName(usr.getPhone());
		//验证用户是否重复注册
		if(user != null){
			header.setZtm(AppConstant.Code_01.USER_DUPLIREGISTER_ERROR);
			return formatResult(header, null);
		}
		//校验验证码
//		 HashMap map = SessionContext.getCache(usr.getPhone());
//		 String authenCode = null;
//		 if(map != null){
//			 authenCode = (String)map.get("authenCode"); 
//		 }
//		 
//		if(authenCode ==null || !authenCode.equals(usr.getAuthenCode())){
//			header.setZtm(AppConstant.Code_01.AUTHENCODE_ERROR);
//			return formatResult(header, null);
//		}
		if(usr.getAuthenCode() ==null || !"343526".equals(usr.getAuthenCode())){
			header.setZtm(AppConstant.Code_01.AUTHENCODE_ERROR);
			return formatResult(header, null);
		}
		SessionContext.removeCache(usr.getPhone());
		
		
		//用户注册
		int result = userService.registerUser(usr);
		if(result != 1){
			header.setZtm(AppConstant.Code_01.USER_REGISTER_ERROR);
			return formatResult(header, null);
		}
		//将用户信息存入session
		HttpSession session = SessionContext.getSession(usr.getPhone());
		session.setAttribute("userinfo", usr);
		
		return formatResult(header, null);
	}

	@Override
	public Map<String, Object> formatResult(Object head, Object object) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(AppConstant.HEAD, head);
		if(object != null){
			map.put(AppConstant.BODY, object);
		}
		return map;
	}

}
