package com.ehualu.rise.web;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.WebConstant;
import com.ehualu.rise.pojo.Header;
import com.ehualu.rise.pojo.ReturnMessage;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		ReturnMessage returnMessage = new ReturnMessage();
		Header header = new Header();
		Map map = request.getParameterMap();
		//判断参数为空的情况
		if(map == null || map.size() == 0){
			header.setZtm(WebConstant.ExecuteFlag.PARAM_IS_NULL);
			returnMessage.setHeader(header);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JSON.toJSON(returnMessage));
			return false;
		}
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			String key = it.next().toString();
			if(((String[])map.get(key))[0]==null || "".equals(((String[])map.get(key))[0])){
				header.setZtm(WebConstant.ExecuteFlag.PARAM_IS_NULL);
				returnMessage.setHeader(header);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(JSON.toJSON(returnMessage));
				return false;
			}
		}

		return super.preHandle(request, response, handler);
	}
}
