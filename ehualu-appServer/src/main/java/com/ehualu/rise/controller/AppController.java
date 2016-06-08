
package com.ehualu.rise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.manager.ServicesManager;
import com.ehualu.rise.pojo.Head;
import com.ehualu.rise.pojo.user.User;
import com.ehualu.rise.service.ServiceInterface;
import com.ehualu.rise.web.SessionContext;

/**
 * APP业务控制
 * @author Administrator
 *
 */
@Controller
public class AppController {

	private static final Logger logger = Logger.getLogger(AppController.class);
	
	private ServicesManager servicesManager;
	
	public ServicesManager getServicesManager() {
		return servicesManager;
	}
	@Inject
	public void setServicesManager(ServicesManager servicesManager) {
		this.servicesManager = servicesManager;
	}
	
	/**
	 * 业务控制
	 * @param head
	 * @param body
	 * @return
	 */
	@RequestMapping(value="/handle",method=RequestMethod.POST)
	public ModelAndView businessController(@RequestParam("head")String head,@RequestParam("body") String body,HttpSession session){
		
		logger.info("接受到的数据：head="+head+"--------body="+body);
		ModelAndView modelView=new ModelAndView();
		//判断包头
		if(head == null){
			Map<String,Object> map = new HashMap<String, Object>();
			Head header = new Head();
			header.setXyh(AppConstant.SERVICE_CODE_SYSTEM);
			header.setZtm(AppConstant.ExecuteFlag.HEAD_IS_NULL);
			map.put(AppConstant.HEAD, header);
			modelView.addAllObjects(map);
			return modelView;
		}
		//判断协议号
		String xyh = JSON.parseObject(head, Head.class).getXyh();
		if(xyh == null){
			Map<String,Object> map = new HashMap<String, Object>();
			Head header = new Head();
			header.setXyh(AppConstant.SERVICE_CODE_SYSTEM);
			header.setZtm(AppConstant.ExecuteFlag.XYH_IS_NULL);
			map.put(AppConstant.HEAD, header);
			modelView.addAllObjects(map);
			return modelView;
		}
		if(AppConstant.SERVICE_CODE_LOGIN.equals(xyh) || AppConstant.SERVICE_CODE_REGISTER.equals(xyh)){
			SessionContext.addSession(JSON.parseObject(body, User.class).getPhone(), session);
		}
		
		ServiceInterface service = servicesManager.getMap().get(xyh);
		Map<String,Object> modelMap = service.handle(head,body);
		modelView.addAllObjects(modelMap);
		logger.info("返回值："+JSON.toJSONString(modelMap));
		return modelView;
	}
}
