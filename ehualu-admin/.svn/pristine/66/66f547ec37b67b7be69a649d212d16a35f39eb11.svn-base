package com.ehualu.rise.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ehualu.rise.auth.AuthClass;
import com.ehualu.rise.auth.AuthMethod;
import com.ehualu.rise.web.CmsSessionContext;


@Controller
@AuthClass("login")
public class AdminController {
	private static final Logger logger = Logger.getLogger(AdminController.class);
	
	@RequestMapping("/admin")
	@AuthMethod
	public String index() {
		logger.error("AdminController /login/admin");
		return "admin/index";
	}
	
	@AuthMethod
	@RequestMapping("/admin/logout")
	public String logout(HttpSession session) {
		logger.error("AdminController /login/admin/logout");
		CmsSessionContext.removeSession(session);
		session.invalidate();
		return "redirect:/login";
	}
}
