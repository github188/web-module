package com.ehualu.rise.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ehualu.rise.auth.AuthClass;
import com.ehualu.rise.page.Pager;
import com.ehualu.rise.pojo.sms.SmsRecord;
import com.ehualu.rise.service.sms.SmsService;
@Controller
@RequestMapping("/admin/sms")
@AuthClass("login")
public class SmsController {
	
	private SmsService smsService;
	
	public SmsService getSmsService() {
		return smsService;
	}
	@Inject
	public void setSmsService(SmsService smsService) {
		this.smsService = smsService;
	}
	/**
	 * 获取用户分页列表集合信息
	 * 
	 * @param model
	 * @return 获取用户分页列表集合信息
	 */
	@RequestMapping("/smsRecords")
	public String listUser(Model model) {
		// 获取用户分页列表集合信息
		Pager<SmsRecord> listRecord = smsService.findSmsRecord();
		// 保存用户分页列表集合信息
		model.addAttribute("datas", listRecord);
		return "sms/list";
	}
}
