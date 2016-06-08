package com.ehualu.rise.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehualu.rise.util.Captcha;
/**
 * 验证码生成
 * @author Bright
 *
 */
@Controller
public class CheckCodeController {
	/**
	 * 获取验证码
	 * @param resp
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping("/drawCheckCode")
	public void drawCheckCode(HttpServletResponse resp, HttpSession session)
			throws IOException {
		resp.setContentType("image/jpg");
		int width = 130;
		int height = 30;
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		session.setAttribute("cc", checkcode);
		OutputStream os = resp.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
	}
/*	@RequestMapping("/validateCheckCode/{yzm}")
	@ResponseBody	//@pathVariable是请求url中的模板变量部分到处理器功能处理方法参数上的绑定
	public String check(@PathVariable("yzm") String yzm,HttpServletResponse resp, HttpSession session)
			throws IOException{
		String checkCode = (String)session.getAttribute("checkCode");
 		if(yzm.equals(checkCode)){
			return "1";
		}
		return "0";
	}
	@RequestMapping("/validateCheckCodes/{yzcode}")
	@ResponseBody	//@pathVariable是请求url中的模板变量部分到处理器功能处理方法参数上的绑定
	public String checks(@PathVariable("yzcode") String yzcode,HttpServletResponse resp, HttpSession session)
			throws IOException{
		String checkCode = (String)session.getAttribute("checkCode");
 		if(yzcode.equals(checkCode)){
			return "1";
		}
		return "0";
	}*/
	
	
	
	
	
	
}
