package com.ehualu.rise.service.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.pojo.Head;
import com.ehualu.rise.pojo.user.UserFeedBack;
import com.ehualu.rise.service.ServiceInterface;

public class UserFeedBackManager implements ServiceInterface {

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
		
		UserFeedBack feedBack = JSON.parseObject(body, UserFeedBack.class);
		int result = userService.insertUserFeedBack(feedBack);
		if(result != 1){
			header.setZtm(AppConstant.Code_01.USER_FEEDBACK_ERROR);
			return formatResult(header, null);
		}
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
