package com.ehualu.rise.controller;

import java.util.Date;
import java.util.List;

import javassist.expr.Instanceof;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.constants.InterfaceConstant;
import com.ehualu.rise.constants.KeyStoreRSA;
import com.ehualu.rise.constants.WebConstant;
import com.ehualu.rise.pojo.Header;
import com.ehualu.rise.pojo.ReturnMessage;
import com.ehualu.rise.pojo.VehicleInfo;
import com.ehualu.rise.pojo.msg.Msg;
import com.ehualu.rise.pojo.msg.SecurityMsg;
import com.ehualu.rise.pojo.violate.Vehicle;
import com.ehualu.rise.pojo.violate.VehicleViolate;
import com.ehualu.rise.pojo.violate.Violation;
import com.ehualu.rise.security.rsa.RSAUtils;
import com.ehualu.rise.util.DateUtil;
import com.ehualu.rise.util.NetUtil;
import com.ehualu.rise.util.SecurityUtil;
import com.ehualu.rise.webservice.VehicleViolationWebService;
import com.ehualu.rise.webservice.VehicleWebService;
import com.ehualu.rise.webservice.ViolationWebService;
/**
 * 违章信息查询
 * @author Bright
 *
 */
@Controller
@RequestMapping(value="/voilation")
public class ViolationController {
	private VehicleViolationWebService vehicleViolationWebService;
	
	
	public VehicleViolationWebService getVehicleViolationWebService() {
		return vehicleViolationWebService;
	}

	@Inject
	public void setVehicleViolationWebService(
			VehicleViolationWebService vehicleViolationWebService) {
		this.vehicleViolationWebService = vehicleViolationWebService;
	}
	
	private ViolationWebService violationWebService;

	public ViolationWebService getViolationWebService() {
		return violationWebService;
	}
	@Inject
	public void setViolationWebService(ViolationWebService violationWebService) {
		this.violationWebService = violationWebService;
	}

	private VehicleWebService vehicleWebService;
	public VehicleWebService getVehicleWebService() {
		return vehicleWebService;
	}
	@Inject
	public void setVehicleWebService(VehicleWebService vehicleWebService) {
		this.vehicleWebService = vehicleWebService;
	}

	/**
	 * 查询机动车违法信息
	 * @param jsonString
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/queryJDCVoilation")
	@ResponseBody
	public ReturnMessage queryJDCVoilation(VehicleViolate vehVio,String checkcode,HttpServletRequest request) throws Exception{
		ReturnMessage returnMessage = new ReturnMessage();
		
		Header header = new Header();
		
		String msgStr = null;
		String outputStr = null;
		byte[] decrypt = null;
		try {
			if(!checkcode.equals("")){
				HttpSession session = request.getSession();
				String cc = (String) session.getAttribute("cc");
				if (!checkcode.equals(cc)) {
					header.setZtm(WebConstant.Code_01.VERIFICATE_CODE_WRONG);
					returnMessage.setHeader(header);
					return returnMessage;
				}
			}
			String jsonString = JSON.toJSONString(vehVio);
			//对数据进行加密
			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonString.getBytes(),
					KeyStoreRSA.INTERFACE_PUBLIC_KEY);
			//签名
			String signature = RSAUtils.sign(encrypt,
					KeyStoreRSA.APPSERVER_PRIVATE_KEY);
			
			SecurityMsg message = new SecurityMsg();
			message.setSignature(signature);
			message.setDigest(encrypt);
//			msgStr = violationComplexWebService.queryViolationComplex(JSON
//					.toJSONString(message));
			msgStr = vehicleViolationWebService.queryVehicleViolate(JSON
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
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
		returnMessage.setHeader(header);
		if(msg.getMsgBody() instanceof List){
			List<JSONObject> resultList = (List<JSONObject>)msg.getMsgBody();
			for(JSONObject obj:resultList){
				obj.put("wfsj", DateUtil.date2Str(new Date((long)obj.get("wfsj")),DateUtil.DEFAULT_PATTERN));
				obj.put("wfdd","辽宁省沈阳市");
				obj.put("wfxw","违章停车");
				obj.put("clsj", DateUtil.date2Str(new Date((long)obj.get("clsj")),DateUtil.DEFAULT_PATTERN));
			}
			returnMessage.setBody(resultList);
		}else{
			returnMessage.setBody(msg.getMsgBody());
		}
		return returnMessage;
	} 
	/**
	 * 查询驾驶证违法信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryDriverLicenseVoilation")
	@ResponseBody
	public ReturnMessage queryDriverLicenseVoilation(Violation violation,String checkcode,HttpServletRequest request){
		
		ReturnMessage returnMessage = new ReturnMessage();
		
		Header header = new Header();
		
		String msgStr = null;
		String outputStr = null;
		byte[] decrypt = null;
		try {
			if(!checkcode.equals("")){
				HttpSession session = request.getSession();
				String cc = (String) session.getAttribute("cc");
				if (!checkcode.equals(cc)) {
					header.setZtm(WebConstant.Code_01.VERIFICATE_CODE_WRONG);
					returnMessage.setHeader(header);
					return returnMessage;
				}
			}
			String jsonString = JSON.toJSONString(violation);
			//对数据进行加密
			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonString.getBytes(),
					KeyStoreRSA.INTERFACE_PUBLIC_KEY);
			//签名
			String signature = RSAUtils.sign(encrypt,
					KeyStoreRSA.APPSERVER_PRIVATE_KEY);
			
			SecurityMsg message = new SecurityMsg();
			message.setSignature(signature);
			message.setDigest(encrypt);
			msgStr = violationWebService.queryViolationByJszh(JSON
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
			header.setZtm(WebConstant.Code_02.DRIVERLICENSE_IS_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode()).equals(InterfaceConstant.Code_004.VIOLATION_JSZH_IS_NULL)) {
			header.setZtm(WebConstant.Code_02.DRIVERLICENSE_IS_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.RESULT_IS_NULL)) {
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
		returnMessage.setHeader(header);
		returnMessage.setBody(msg.getMsgBody());
		return returnMessage;
	}
	
	/**
	 * 通过决定书编号查询违法信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryJDSVoilation")
	@ResponseBody
	public ReturnMessage queryJDSVoilation(Violation violation){
		
		ReturnMessage returnMessage = new ReturnMessage();
		
		Header header = new Header();
		
		String msgStr = null;
		String outputStr = null;
		byte[] decrypt = null;

		try {
//			String jsonString = NetUtil.fetchHttpReqContent(request);
			//对决定书编号进行md5加密
//			Violation violation = JSON.parseObject(jsonString, Violation.class);
			//violation.setJdsbh(SecurityUtil.md5(violation.getJdsbh()));
			
			String jsonString = JSON.toJSONString(violation);
			//对数据进行加密
			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonString.getBytes(),
					KeyStoreRSA.INTERFACE_PUBLIC_KEY);
			//签名
			String signature = RSAUtils.sign(encrypt,
					KeyStoreRSA.APPSERVER_PRIVATE_KEY);
			
			SecurityMsg message = new SecurityMsg();
			message.setSignature(signature);
			message.setDigest(encrypt);
			msgStr = violationWebService.queryEnViolationByJdsbh(JSON
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
			header.setZtm(WebConstant.Code_02.JDSBH_IS_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode()).equals(InterfaceConstant.Code_004.VIOLATION_JSZH_IS_NULL)) {
			header.setZtm(WebConstant.Code_02.JDSBH_IS_NULL);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		if ((msg.getStatuCode())
				.equals(InterfaceConstant.RESULT_IS_NULL)) {
			header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
		returnMessage.setHeader(header);
		returnMessage.setBody(msg.getMsgBody());
		
		return returnMessage;
	}
	/**
	 * 查询机动车信息
	 * @param vehicle
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryJDCInfo")
	@ResponseBody
	public ReturnMessage queryJDCInfo(Vehicle vehicle) throws Exception{
		ReturnMessage returnMessage = new ReturnMessage();		
		Header header = new Header();
		
		String msgStr = null;
		String outputStr = null;
		byte[] decrypt = null;
		VehicleInfo vehicleInfo = new VehicleInfo();
		try {
			String fdjh = vehicle.getFdjh();
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
				header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
				returnMessage.setHeader(header);
				return returnMessage;
			}
		
			
			vehicle = JSON.parseObject(msg.getMsgBody().toString(), Vehicle.class);
			vehicleInfo.setClsbdh(vehicle.getClsbdh());
			vehicleInfo.setCllx(vehicle.getCllx());
			vehicleInfo.setZt(vehicle.getZt());
			vehicleInfo.setNjdqsj(DateUtil.subDay(DateUtil.getCurrentTime(), vehicle.getYxqz()));

			vehicle.setHphm("辽"+vehicle.getHphm());
			vehicle.setFdjh(fdjh);
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
				for(JSONObject obj : resultList){
					fkje += obj.getDoubleValue("fkje");
					kf += obj.getIntValue("wfjfs");
				}
			}
			vehicleInfo.setFkje(fkje);
			vehicleInfo.setKf(kf);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			header.setZtm(WebConstant.ExecuteFlag.SYSTEM_IS_EXCEPTION);
			returnMessage.setHeader(header);
			return returnMessage;
		}
		
		
		header.setZtm(WebConstant.ExecuteFlag.STATUS_SUCCESS);
		returnMessage.setHeader(header);
		returnMessage.setBody(vehicleInfo);
		return returnMessage;
	}

}
