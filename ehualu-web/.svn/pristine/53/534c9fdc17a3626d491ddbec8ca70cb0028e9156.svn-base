package com.ehualu.rise.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.constants.InterfaceConstant;
import com.ehualu.rise.constants.KeyStoreRSA;
import com.ehualu.rise.constants.WebConstant;
import com.ehualu.rise.dto.UserDto;
import com.ehualu.rise.pojo.Header;
import com.ehualu.rise.pojo.ReturnMessage;
import com.ehualu.rise.pojo.VehicleInfo;
import com.ehualu.rise.pojo.log.LoginLog;
import com.ehualu.rise.pojo.msg.Msg;
import com.ehualu.rise.pojo.msg.SecurityMsg;
import com.ehualu.rise.pojo.user.User;
import com.ehualu.rise.pojo.user.UserDriverLicense;
import com.ehualu.rise.pojo.user.UserVehicle;
import com.ehualu.rise.pojo.violate.DrivingLicense;
import com.ehualu.rise.pojo.violate.Vehicle;
import com.ehualu.rise.security.rsa.RSAUtils;
import com.ehualu.rise.service.log.LoginLogService;
import com.ehualu.rise.service.user.UserDriverLicenseService;
import com.ehualu.rise.service.user.UserService;
import com.ehualu.rise.service.user.UserVehicleService;
import com.ehualu.rise.util.DateUtil;
import com.ehualu.rise.util.SecurityUtil;
import com.ehualu.rise.webservice.DrivingLicenseWebService;
import com.ehualu.rise.webservice.VehicleViolationWebService;
import com.ehualu.rise.webservice.VehicleWebService;
import com.ehualu.rise.webservice.ViolationWebService;

/**
 * 用户登录
 * @author Bright
 *
 */
@Controller
@RequestMapping(value="/admin")
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	
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
	
	private VehicleWebService vehicleWebService;
	
	public VehicleWebService getVehicleWebService() {
		return vehicleWebService;
	}
	@Inject
	public void setVehicleWebService(VehicleWebService vehicleWebService) {
		this.vehicleWebService = vehicleWebService;
	}

	private UserVehicleService userVehicleService;
	public UserVehicleService getUserVehicleService() {
		return userVehicleService;
	}
	@Inject
	public void setUserVehicleService(UserVehicleService userVehicleService) {
		this.userVehicleService = userVehicleService;
	}
	
	private DrivingLicenseWebService drivingLicenseWebService;

	public DrivingLicenseWebService getDrivingLicenseWebService() {
		return drivingLicenseWebService;
	}
	@Inject
	public void setDrivingLicenseWebService(
			DrivingLicenseWebService drivingLicenseWebService) {
		this.drivingLicenseWebService = drivingLicenseWebService;
	}
	
	private UserDriverLicenseService userDriverLicenseService;

	public UserDriverLicenseService getUserDriverLicenseService() {
		return userDriverLicenseService;
	}
	@Inject
	public void setUserDriverLicenseService(
			UserDriverLicenseService userDriverLicenseService) {
		this.userDriverLicenseService = userDriverLicenseService;
	}

	private VehicleViolationWebService vehicleViolationWebService;
	
	public VehicleViolationWebService getVehicleViolationWebService() {
		return vehicleViolationWebService;
	}

	@Inject
	public void setVehicleViolationWebService(
			VehicleViolationWebService vehicleViolationWebService) {
		this.vehicleViolationWebService = vehicleViolationWebService;
	}
	/**
	 * 用户登录 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public ReturnMessage login(User user,HttpServletRequest request) {
		
		ReturnMessage returnMessage =new ReturnMessage();
		
		Header header = new Header();
		
		HttpSession session = request.getSession();
		try{
			//String jsonString = NetUtil.fetchHttpReqContent(request);
			
			//User user = JSON.parseObject(jsonString, User.class);
			
//			String checkcode = user.getCc();
					
//			String cc = (String) session.getAttribute("cc");
//			if (!checkcode.equals(cc)) {
//				header.setZtm(WebConstant.Code_01.CHECKCODE_IS_WRONG);
//				returnMessage.setHeader(header);
//				return returnMessage;
//			}
			
			User usr = userService.queryByUserName(user.getUsername());
			if (usr == null) {
				header.setZtm(WebConstant.Code_01.USER_PWD_IS_WRONG);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			if(!user.getPassword().equals(usr.getPassword())){
				header.setZtm(WebConstant.Code_01.USER_PWD_IS_WRONG);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			userService.updateUserLoginStatus(usr.getUsername(),
					AppConstant.USERLOG_STATE_LOGIN); 
			
			
			LoginLog record = new LoginLog();
			record.setPhone(usr.getPhone());
			record.setMac(usr.getMac());
			record.setMfrs(usr.getMfrs());
			record.setModel(usr.getModel());
			record.setOptTime(DateUtil.getTimestamp());
			record.setAction(AppConstant.USERLOG_STATE_LOGIN);
			loginLogService.insertLoginLog(record);
			//session.removeAttribute("cc");
			
			UserDto userDto = new UserDto();
			userDto.setPhone(usr.getUsername());
			userDto.setUserName(usr.getUsername());
			userDto.setNick(usr.getNick());
			userDto.setPassword(usr.getPassword());
			userDto.setCreateDate(usr.getCreateDate());
			userDto.setEmail(usr.getEmail());
			userDto.setLastLoginDate(DateUtil.date2Str(loginLogService.findLastLoginTime(usr.getPhone()), DateUtil.HOUR_12HMS_PATTERN));
			
			session.setAttribute("userinfo", userDto);
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
			returnMessage.setBody(userDto);
			
		}catch(Exception e){
			logger.info(e);
			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}			
		return returnMessage;
	}
	/**
	 * 用户注册
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/registerUser")
	@ResponseBody
	public ReturnMessage registerUser(User usr,HttpServletRequest request) {
		ReturnMessage returnMessage =new ReturnMessage();
		Header header = new Header();
		try{
			//String jsonString = NetUtil.fetchHttpReqContent(request);
			
			//User usr = JSON.parseObject(jsonString, User.class);
			usr.setPhone(usr.getUsername());
			usr.setStatus(AppConstant.USER_STATE_VALID);
			usr.setCreateDate(DateUtil.getSqlDate());
			
			User user = userService.queryByUserName(usr.getUsername());
			//验证用户是否重复注册
			if(user != null){
				header.setZtm(WebConstant.Code_01.PHONE_DUPLICATE_WRONG);
				returnMessage.setHeader(header);
				return returnMessage;
			}
//			if(usr.getAuthenCode() ==null || !"343526".equals(usr.getAuthenCode())){
//				header.setZtm(WebConstant.Code_01.VERIFICATE_CODE_WRONG);
//				returnMessage.setHeader(header);
//				return returnMessage;
//			}
			//用户注册
			int result = userService.registerUser(usr);
			UserDto userDto = new UserDto();
			userDto.setPhone(usr.getUsername());
			userDto.setUserName(usr.getUsername());
			userDto.setNick(usr.getNick());
			userDto.setPassword(usr.getPassword());
			userDto.setCreateDate(usr.getCreateDate());
			userDto.setEmail(usr.getEmail());
			userDto.setLastLoginDate(DateUtil.getCurDateTime());
			//将用户信息存入session
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", userDto);
			
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
			returnMessage.setBody(userDto);
			
		}catch(Exception e){
			logger.info(e);
			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}			
		return returnMessage;
	}
	/**
	 * 用户信息修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/changeUserInfo")
	@ResponseBody
	public ReturnMessage changeUserInfo(User user,HttpServletRequest request) {
		ReturnMessage returnMessage =new ReturnMessage();
		Header header = new Header();
		try{
			//String jsonString = NetUtil.fetchHttpReqContent(request);
			
			//User user = JSON.parseObject(jsonString, User.class);
			
			User usr = userService.queryByUserName(user.getUsername());
			if (usr == null) {
				header.setZtm(WebConstant.Code_01.USER_PWD_IS_WRONG);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			if(!user.getPassword().equals(usr.getPassword())){
				header.setZtm(WebConstant.Code_01.USER_PWD_IS_WRONG);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			
			userService.updateUserInfo(user);

			
			
			UserDto userDto = new UserDto();
			userDto.setPhone(user.getUsername());
			userDto.setUserName(user.getUsername());
			userDto.setNick(user.getNick());
			userDto.setCreateDate(usr.getCreateDate());
			userDto.setEmail(user.getEmail());
			userDto.setLastLoginDate(DateUtil.date2Str(loginLogService.findLastLoginTime(usr.getPhone()), DateUtil.HOUR_12HMS_PATTERN));
			//将用户信息存入session
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", userDto);
			
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
			returnMessage.setBody(userDto);
			
		}catch(Exception e){
			logger.info(e);
			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}			
		return returnMessage;
	}
	/**
	 * 用户密码修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/changePassword")
	@ResponseBody
	public ReturnMessage changePassword(User usrs,User usr,HttpServletRequest request) {
		
		ReturnMessage returnMessage =new ReturnMessage();
		Header header = new Header();
		try{
			//String jsonString = NetUtil.fetchHttpReqContent(request);
			//User usr = JSON.parseObject(jsonString, User.class);
			User user = userService.queryByUserName(usr.getUsername());

			if (!usr.getPassword().equals(user.getPassword())) {
				header.setZtm(WebConstant.Code_01.USER_PWD_IS_WRONG);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			if(usr.getNewPassword().equals(user.getPassword())){
				header.setZtm(WebConstant.Code_01.PWD_OLDPWD_SAME_WRONG);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			userService.updatePasswordByUserName(usr.getUsername(), usr.getNewPassword());
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
		}catch(Exception e){
			logger.info(e);
			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}			
		return returnMessage;
	}
	/**
	 * 用户找回密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findPassword")
	@ResponseBody
	public ReturnMessage findPassword(User usr,HttpServletRequest request, String checkcode) {
		
		ReturnMessage returnMessage =new ReturnMessage();
		Header header = new Header();
		try{
			User user = userService.queryByUserName(usr.getUsername());
			//用户不存在
			if (user == null) {
				header.setZtm(WebConstant.Code_01.USER_NOT_EXISTS);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			
			HttpSession session = request.getSession();
			String cc = (String) session.getAttribute("cc");
			if (checkcode!=null&&!checkcode.equals(cc)) {
				header.setZtm(WebConstant.Code_01.VERIFICATE_CODE_WRONG);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			//HttpSession session = request.getSession();
//			 String authenCode = (String)session.get("authenCode"); 
//			 if(authenCode ==null || !authenCode.equals(usr.getAuthenCode())){
//			 header.setZtm(WebConstant.Code_01.VERIFICATE_CODE_WRONG);//校验失败
//			returnMessage.setHeader(header);
			//return returnMessage;
//			 }
			session.removeAttribute("cc");
			int upPwd= userService.updatePasswordByUserName(usr.getUsername(), usr.getNewPassword());
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
		}catch(Exception e){
			logger.info(e);
			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}			
		return returnMessage;
	}
	/**
	 * 用户登出
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logOut")
	@ResponseBody
	public ReturnMessage logOut(User usr,HttpServletRequest request) {
		
		ReturnMessage returnMessage =new ReturnMessage();
		Header header = new Header();
		
		try {
			HttpSession session = request.getSession();
			//String jsonString = NetUtil.fetchHttpReqContent(request);
			//User usr = JSON.parseObject(jsonString, User.class);
			userService.updateUserLoginStatus(usr.getUsername(),
					AppConstant.USERLOG_STATE_LOGOUT);
			LoginLog record = new LoginLog();
			record.setPhone(usr.getUsername());
			record.setMac(usr.getMac());
			record.setMfrs(usr.getMfrs());
			record.setModel(usr.getModel());
			record.setOptTime(DateUtil.getTimestamp());
			record.setAction(AppConstant.USERLOG_STATE_LOGOUT);
			loginLogService.insertLoginLog(record);
			session.removeAttribute("userinfo");
			session.invalidate();
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
		} catch (Exception e) {
			e.printStackTrace();
			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		return returnMessage;
	}
	/**
	 * 用户绑定机动车
	 * @param vehicleEn
	 * @return
	 */
	@RequestMapping(value="/boundUserVehicle")
	@ResponseBody
	public ReturnMessage boundUserVehicle(User user,Vehicle vehicle){
		
		ReturnMessage returnMessage = new ReturnMessage();
		
		Header header = new Header();
		
		String msgStr = null;
		String outputStr = null;
		byte[] decrypt = null;
		String hphm = vehicle.getHphm(); 
		String hpzl = vehicle.getHpzl();
		String fdjh = vehicle.getFdjh();
		if (user == null || user.getUsername() == null || "".equals(user.getUsername())) {
			header.setZtm(WebConstant.Code_02.USERNAME_IS_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		UserVehicle userVehicle = new UserVehicle();
		userVehicle.setUsername(user.getUsername());
		userVehicle.setHphm(vehicle.getHphm());
		try {
			//验证用户是否重复绑定机动车
			userVehicle = userVehicleService.queryUserVehicle(userVehicle);
			if(userVehicle != null){
				header.setZtm(WebConstant.Code_02.JDC_BOUND_EXISTS);
				returnMessage.setHeader(header);
				return returnMessage;
			}
//			String jsonString = NetUtil.fetchHttpReqContent(request);
			//对决定书编号进行md5加密
//			Violation violation = JSON.parseObject(jsonString, Violation.class);
			
			//vehicle.setHphm(SecurityUtil.md5(vehicle.getHphm()));
			
			String jsonString = JSON.toJSONString(vehicle);
			//对数据进行加密
			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonString.getBytes(),
					KeyStoreRSA.INTERFACE_PUBLIC_KEY);
			//签名
			String signature = RSAUtils.sign(encrypt,
					KeyStoreRSA.APPSERVER_PRIVATE_KEY);
			
			SecurityMsg message = new SecurityMsg();
			message.setSignature(signature);
			message.setDigest(encrypt);
			msgStr = vehicleWebService.queryEnVehicleByHphm(JSON
			.toJSONString(message));
			SecurityMsg sMsg = JSON.parseObject(msgStr, SecurityMsg.class);
			boolean isOK = RSAUtils.verify(sMsg.getDigest(),
					KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
			//对interface返回信息进行验签
			if(!isOK){
				//web网站验证interface签名失败
				header.setZtm(AppConstant.ExecuteFlag.SIGN_VERIFY_WRONG_APPSERVER);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			System.out.println("isOK:" + isOK);
			System.out.println("sMsg.getDigest():" + sMsg.getDigest());
			//对返回i型纳西进行解密
			decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(),
					KeyStoreRSA.APPSERVER_PRIVATE_KEY);
			outputStr = new String(decrypt, "gbk");
			System.out.println("outputStr:" + outputStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		//解析返回信息
		Msg msg = JSON.parseObject(new String(decrypt), Msg.class);
		if ((msg.getStatuCode()).equals(InterfaceConstant.SIGN_VERIFY_WRONG)) {
			header.setZtm(AppConstant.ExecuteFlag.SIGN_VERIFY_WRONG_INTERFACE);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode()).equals(InterfaceConstant.PARAM_IS_NULL)) {
			header.setZtm(WebConstant.Code_02.HPHM_HPZL_IS_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.Code_001.HPHM_IS_NULL)) {
			header.setZtm(WebConstant.Code_02.HPHM_IS_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.Code_001.HPZL_IS_NULL)) {
			header.setZtm(WebConstant.Code_02.HPZL_IS_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.Code_001.HPZL_NO_MATCH)) {
			header.setZtm(WebConstant.Code_02.HPZL_NO_MATCH);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.Code_001.FDJH_IS_NULL)) {
			header.setZtm(WebConstant.Code_02.FDJH_IS_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.Code_001.FDJH_RESULT_NULL)) {
			header.setZtm(WebConstant.Code_02.FDJH_RESULT_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.Code_001.FDJH_NO_MATCH)) {
			header.setZtm(WebConstant.Code_02.FDJH_NO_MATCH);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.RESULT_IS_NULL)) {
			header.setZtm(WebConstant.Code_02.JDC_NOT_EXISTS);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		//绑定机动车
		userVehicle = new UserVehicle();
		userVehicle.setUsername(user.getUsername());
		userVehicle.setHphm(hphm);
		userVehicle.setFdjh(fdjh);
		userVehicle.setHpzl(hpzl);
		
		userVehicleService.insertOrUpdateUserVehicle(userVehicle);
		
		header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
		returnMessage.setHeader(header);
		//returnMessage.setBody(msg.getMsgBody());
		
		return returnMessage;
	}
	/**
	 * 查询用户绑定机动车
	 * @param vehicleEn
	 * @return
	 */
	@RequestMapping(value="/queryBoundVehicle")
	@ResponseBody
	public ReturnMessage queryBoundVehicle(UserVehicle userVehicle){
		ReturnMessage returnMessage = new ReturnMessage();
		Header header = new Header();
		try{
			
			List<UserVehicle> userVehicleList = userVehicleService.queryUserVehicleByUsername(userVehicle);
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
			returnMessage.setBody(userVehicleList);
			
		}catch(Exception e){
			e.printStackTrace();

			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}
	
		
		return returnMessage;
	}
	
	/**
	 * 查询用户绑定机动车
	 * @param vehicleEn
	 * @return
	 */
	@RequestMapping(value="/queryBoundVehicleMore")
	@ResponseBody
	public ReturnMessage queryBoundVehicleMore(UserVehicle userVehicle){
		ReturnMessage returnMessage = new ReturnMessage();
		Header header = new Header();
		String msgStr = null;
		String outputStr = null;
		byte[] decrypt = null;
		try{
			List<UserVehicle> userVehicleList = userVehicleService.queryUserVehicleByUsername(userVehicle);
			List<VehicleInfo> vehicleInfoList = new ArrayList<VehicleInfo>();
			for(UserVehicle obj:userVehicleList){
				VehicleInfo vehicleInfo = new VehicleInfo();	
				Vehicle vehicle = new Vehicle();
				vehicle.setHphm(obj.getHphm());
				String jsonString = JSON.toJSONString(vehicle);
				//对数据进行加密
				byte[] encrypt = RSAUtils.encryptByPublicKey(jsonString.getBytes(),
						KeyStoreRSA.INTERFACE_PUBLIC_KEY);
				//签名
				String signature = RSAUtils.sign(encrypt,
						KeyStoreRSA.APPSERVER_PRIVATE_KEY);
				
				SecurityMsg message = new SecurityMsg();
				message.setSignature(signature);
				message.setDigest(encrypt);
				msgStr = vehicleWebService.queryEnVehicleByHphm(JSON.toJSONString(message));
				
				SecurityMsg sMsg = JSON.parseObject(msgStr, SecurityMsg.class);
				boolean isOK = RSAUtils.verify(sMsg.getDigest(),
						KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
				//对interface返回信息进行验签
				if(!isOK){
					//web网站验证interface签名失败
					header.setZtm(AppConstant.ExecuteFlag.SIGN_VERIFY_WRONG_APPSERVER);
					returnMessage.setHeader(header);
					return returnMessage;
				}
				System.out.println("isOK:" + isOK);
				System.out.println("sMsg.getDigest():" + sMsg.getDigest());
				//对返回i型纳西进行解密
				decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(),
						KeyStoreRSA.APPSERVER_PRIVATE_KEY);
				outputStr = new String(decrypt, "gbk");
				System.out.println("outputStr:" + outputStr);
				//解析返回信息
				Msg msg = JSON.parseObject(outputStr, Msg.class);				
				vehicle = JSON.parseObject(msg.getMsgBody().toString(), Vehicle.class);

				vehicleInfo.setHpzl(vehicle.getHpzl());
				vehicleInfo.setSyr(vehicle.getSyr());
				vehicleInfo.setFdjh(vehicle.getFdjh());
				vehicleInfo.setHphm(vehicle.getHphm());
				vehicleInfo.setClsbdh(vehicle.getClsbdh());
				vehicleInfo.setCllx(vehicle.getCllx());
				vehicleInfo.setZt(vehicle.getZt());
				vehicleInfo.setNjdqsj(DateUtil.subDay(DateUtil.getCurrentTime(), vehicle.getYxqz()));
				vehicle.setHphm("辽"+vehicle.getHphm());
				vehicle.setFdjh(vehicle.getFdjh().substring(vehicle.getFdjh().length()-6,vehicle.getFdjh().length()));
				jsonString = JSON.toJSONString(vehicle);
				//对数据进行加密
				encrypt = RSAUtils.encryptByPublicKey(jsonString.getBytes(),
						KeyStoreRSA.INTERFACE_PUBLIC_KEY);
				//签名
				signature = RSAUtils.sign(encrypt,
						KeyStoreRSA.APPSERVER_PRIVATE_KEY);
				
				message = new SecurityMsg();
				message.setSignature(signature);
				message.setDigest(encrypt);
				//查询机动车违章信息
				msgStr = vehicleViolationWebService.queryVehicleViolate(JSON.toJSONString(message));
			    sMsg = JSON.parseObject(msgStr, SecurityMsg.class);
				isOK = RSAUtils.verify(sMsg.getDigest(),
						KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
				//对interface返回信息进行验签
				if(!isOK){
					//web网站验证interface签名失败
					header.setZtm(AppConstant.ExecuteFlag.SIGN_VERIFY_WRONG_APPSERVER);
					returnMessage.setHeader(header);
					return returnMessage;
				}
				System.out.println("isOK:" + isOK);
				System.out.println("sMsg.getDigest():" + sMsg.getDigest());
				//对返回i型纳西进行解密
				decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(),
						KeyStoreRSA.APPSERVER_PRIVATE_KEY);
				outputStr = new String(decrypt, "gbk");
				System.out.println("outputStr:" + outputStr);
				//解析返回信息
				double fkje = 0.0;
				int kf = 0;
				msg = JSON.parseObject(outputStr, Msg.class);
				if(msg.getMsgBody() instanceof List){
					List<JSONObject> resultList = (List<JSONObject>)msg.getMsgBody();
					vehicleInfo.setWclts(resultList.size());
					for(JSONObject jsonobj : resultList){
						fkje += jsonobj.getDoubleValue("fkje");
						kf += jsonobj.getIntValue("wfjfs");
					}
				}
				vehicleInfo.setFkje(fkje);
				vehicleInfo.setKf(kf);
				vehicleInfoList.add(vehicleInfo);
			}
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
			returnMessage.setBody(vehicleInfoList);
			
		}catch(Exception e){
			e.printStackTrace();

			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}
	
		
		return returnMessage;
	}
	
	/**
	 * 用户绑定驾驶证
	 * @param user
	 * @param vehicle
	 * @return
	 */
	@RequestMapping(value="/boundUserDriverLicense")
	@ResponseBody
	public ReturnMessage boundUserDriverLicense(User user,DrivingLicense drivingLicense,UserDriverLicense userLicense){
		
		ReturnMessage returnMessage = new ReturnMessage();
		
		Header header = new Header();
		
		String msgStr = null;
		String outputStr = null;
		byte[] decrypt = null;
		if (user == null || user.getUsername() == null || "".equals(user.getUsername())) {
			header.setZtm(WebConstant.Code_02.USERNAME_IS_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		
		try {
			drivingLicense.setSfzmhm(userLicense.getZjhm());
			//验证驾驶证是否重复绑定
			userLicense = userDriverLicenseService.queryUserDriverLicense(userLicense);
			if(userLicense != null){
				header.setZtm(WebConstant.Code_02.JSZ_BOUND_EXISTS);
				returnMessage.setHeader(header);
				return returnMessage;
			}
//			String jsonString = NetUtil.fetchHttpReqContent(request);
			//对决定书编号进行md5加密
//			Violation violation = JSON.parseObject(jsonString, Violation.class);
			String jsonString = JSON.toJSONString(drivingLicense);
			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonString.getBytes(),
					KeyStoreRSA.INTERFACE_PUBLIC_KEY);

			String signature = RSAUtils.sign(encrypt,
					KeyStoreRSA.APPSERVER_PRIVATE_KEY);

			SecurityMsg message = new SecurityMsg();
			message.setSignature(signature);
			message.setDigest(encrypt);
			msgStr = drivingLicenseWebService.queryEnLicenseBySfzmhm(JSON.toJSONString(message));
			
			SecurityMsg sMsg = JSON.parseObject(msgStr, SecurityMsg.class);
			boolean isOK = RSAUtils.verify(sMsg.getDigest(),
					KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
			//对interface返回信息进行验签
			if(!isOK){
				//web网站验证interface签名失败
				header.setZtm(AppConstant.ExecuteFlag.SIGN_VERIFY_WRONG_APPSERVER);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			System.out.println("isOK:" + isOK);
			System.out.println("sMsg.getDigest():" + sMsg.getDigest());
			//对返回i型纳西进行解密
			decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(),
					KeyStoreRSA.APPSERVER_PRIVATE_KEY);
			outputStr = new String(decrypt, "gbk");
			System.out.println("outputStr:" + outputStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		//解析返回信息
		Msg msg = JSON.parseObject(new String(decrypt), Msg.class);
		if ((msg.getStatuCode()).equals(InterfaceConstant.SIGN_VERIFY_WRONG)) {
			header.setZtm(AppConstant.ExecuteFlag.SIGN_VERIFY_WRONG_INTERFACE);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode()).equals(InterfaceConstant.Code_002.LICENSE_SFZMHM_IS_NULL)) {
			header.setZtm(WebConstant.Code_02.DRIVERLICENSE_IS_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.RESULT_IS_NULL)) {
			header.setZtm(WebConstant.Code_02.JSZ_NOT_EXISTS);
			returnMessage.setHeader(header);
			return returnMessage;
		}
			
		DrivingLicense drivingLicensereuslt = JSON.parseObject(msg.getMsgBody().toString(), DrivingLicense.class);
		
		//姓名不匹配
		if(!drivingLicense.getXm().equals(drivingLicensereuslt.getXm())){
			header.setZtm(WebConstant.Code_02.XM_NOT_EXISTS);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		//档案编号不匹配
		if(!drivingLicense.getDabh().equals(drivingLicensereuslt.getDabh())){
			header.setZtm(WebConstant.Code_02.DABH_NOT_EXISTS);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		//证芯编号不匹配
		if(!drivingLicense.getZxbh().equals(drivingLicensereuslt.getZxbh())){
			header.setZtm(WebConstant.Code_02.ZXBH_NOT_EXISTS);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		
		//绑定机动车
		UserDriverLicense userDriverLicense = new UserDriverLicense();
		
		userDriverLicense.setUsername(user.getUsername());
		userDriverLicense.setXm(drivingLicensereuslt.getXm());
		userDriverLicense.setZjhm(drivingLicensereuslt.getSfzmhm());
		userDriverLicense.setZxbh(drivingLicensereuslt.getZxbh());
		userDriverLicense.setDabh(drivingLicensereuslt.getDabh());

		userDriverLicenseService.insertOrUpdateUserDriverLicense(userDriverLicense);
		
		header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
		returnMessage.setHeader(header);
		//returnMessage.setBody(msg.getMsgBody());
		
		return returnMessage;
	}
	/**
	 * 查询用户绑定驾驶证
	 * @param vehicleEn
	 * @return
	 */
	@RequestMapping(value="/queryBoundDriverLicense")
	@ResponseBody
	public ReturnMessage queryBoundDriverLicense(UserDriverLicense userDriverLicense){
		ReturnMessage returnMessage = new ReturnMessage();
		Header header = new Header();
		try{
			
			List<UserDriverLicense> userDriverLicenseList = userDriverLicenseService.queryUserDriverLicenseByUsername(userDriverLicense);
			
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
			returnMessage.setBody(userDriverLicenseList);
			
		}catch(Exception e){
			e.printStackTrace();

			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}
	
		return returnMessage;
	}
	/**
	 * 解绑机动车
	 * @param userVehicle
	 * @return
	 */
	@RequestMapping(value="/unboundUserVehicle")
	@ResponseBody
	public ReturnMessage unboundUserVehicle(UserVehicle userVehicle){
		ReturnMessage returnMessage = new ReturnMessage();
		Header header = new Header();
		try{
			//用户名为空
			if(userVehicle.getUsername()==null || "".equals(userVehicle.getUsername())){
				header.setZtm(WebConstant.Code_02.USERNAME_IS_NULL);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			//号牌号码为空
			if(userVehicle.getHphm() == null || "".equals(userVehicle.getHphm())){
				header.setZtm(WebConstant.Code_02.HPHM_IS_NULL);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			userVehicleService.unboundUserVehicle(userVehicle);
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
			
		}catch(Exception e){
			e.printStackTrace();

			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}
	
		return returnMessage;
	}
	/**
	 * 解绑驾驶证
	 * @param userVehicle
	 * @return
	 */
	@RequestMapping(value="/unboundUserDriverLicense")
	@ResponseBody
	public ReturnMessage unboundUserDriverLicense(UserDriverLicense userDriverLicense){
		ReturnMessage returnMessage = new ReturnMessage();
		Header header = new Header();
		try{
			//用户名为空
			if(userDriverLicense.getUsername()==null || "".equals(userDriverLicense.getUsername())){
				header.setZtm(WebConstant.Code_02.USERNAME_IS_NULL);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			//证件号码为空
			if(userDriverLicense.getZjhm() == null || "".equals(userDriverLicense.getZjhm())){
				header.setZtm(WebConstant.Code_02.LICENSE_SFZMHM_IS_NULL);
				returnMessage.setHeader(header);
				return returnMessage;
			}
			
			userDriverLicenseService.unboundUserDriverLicense(userDriverLicense);
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
			
		}catch(Exception e){
			e.printStackTrace();

			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}
	
		return returnMessage;
	}
	

	
}
