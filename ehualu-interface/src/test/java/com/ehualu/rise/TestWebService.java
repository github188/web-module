//package com.ehualu.rise;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.alibaba.fastjson.JSON;
//import com.ehualu.rise.pojo.msg.SecurityMsg;
//import com.ehualu.rise.pojo.violate.DrivingLicenseEn;
//import com.ehualu.rise.pojo.violate.VehicleEn;
//import com.ehualu.rise.pojo.violate.VehicleViolateEn;
//import com.ehualu.rise.pojo.violate.ViolationComplex;
//import com.ehualu.rise.pojo.violate.ViolationEn;
//import com.ehualu.rise.security.rsa.RSAUtils;
//import com.ehualu.rise.util.SecurityUtil;
//import com.ehualu.rise.webservice.DrivingLicenseWebService;
//import com.ehualu.rise.webservice.VehicleViolationWebService;
//import com.ehualu.rise.webservice.VehicleWebService;
//import com.ehualu.rise.webservice.ViolationComplexWebService;
//import com.ehualu.rise.webservice.ViolationWebService;
//
//
///**
// * 测试interface接口
// * @author Administrator
// *
// */
//public class TestWebService {
//
//	ClassPathXmlApplicationContext context=null;
//	@Before
//	public void init(){
//		context = new ClassPathXmlApplicationContext("file:F:/Workspaces/MyEclipse Professional 2014/ehualu-interface/src/test/resources/spring.xml");
//		context.start();
//	}
//	
//	/**
//	 * 通过身份证号查询加密的驾驶证信息
//	 */
////	@Test
//	public void queryEnLicenseBySfzmhm(){
//		try {
//			DrivingLicenseEn dl = new DrivingLicenseEn();
//			dl.setSfzmhm(SecurityUtil.md5("350203197205014123"));
//			String jsonStr2 = JSON.toJSONString(dl);
//			DrivingLicenseWebService drivingLicenseWebService = (DrivingLicenseWebService)context.getBean("drivingLicenseWebService"); // 获取远程服务代理
//			
//			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonStr2.getBytes(), KeyStoreRSA.INTERFACE_PUBLIC_KEY);
//			String sign = RSAUtils.sign(encrypt, KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//	        SecurityMsg securityMsg = new SecurityMsg();
//	        securityMsg.setSignature(sign);
//	        securityMsg.setDigest(encrypt);
//	        String jsonSt2 = JSON.toJSONString(securityMsg);
//	        
//	        String twoJSON = drivingLicenseWebService.queryEnLicenseBySfzmhm(jsonSt2);
//	        System.out.println("twoJSON:"+twoJSON);
//			
//			SecurityMsg sMsg = JSON.parseObject(twoJSON, SecurityMsg.class);
//			boolean isOK = RSAUtils.verify(sMsg.getDigest(), KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
//			System.out.println("isOK:"+isOK);
//			System.out.println("sMsg.getDigest():"+sMsg.getDigest());
//			byte[] decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(), KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//			String outputStr = new String(decrypt,"gbk");
//			System.out.println("outputStr:"+outputStr);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	/**
//	 * 通过车牌号码查询加密的车辆信息
//	 */
////	@Test
//	public void queryEnVehicleByHphm(){
//		try {
//			VehicleEn vehicle = new VehicleEn();
//			vehicle.setHphm(SecurityUtil.md5("DR6368"));
//			vehicle.setFdjh("005754");
//			String jsonStr3 = JSON.toJSONString(vehicle);
//			VehicleWebService vehicleWebService = (VehicleWebService)context.getBean("vehicleWebService"); // 获取远程服务代理
//			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonStr3.getBytes(), KeyStoreRSA.INTERFACE_PUBLIC_KEY);
//			String sign = RSAUtils.sign(encrypt, KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//	        SecurityMsg securityMsg = new SecurityMsg();
//	        securityMsg.setSignature(sign);
//	        securityMsg.setDigest(encrypt);
//	        String jsonSt3 = JSON.toJSONString(securityMsg);
//	        
//	        String threeJSON = vehicleWebService.queryEnVehicleByHphm(jsonSt3);
//	        System.out.println("threeJSON:"+threeJSON);
//			
//			SecurityMsg sMsg = JSON.parseObject(threeJSON, SecurityMsg.class);
//			boolean isOK = RSAUtils.verify(sMsg.getDigest(), KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
//			System.out.println("isOK:"+isOK);
//			System.out.println("sMsg.getDigest():"+sMsg.getDigest());
//			byte[] decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(), KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//			String outputStr = new String(decrypt,"gbk");
//			System.out.println("outputStr:"+outputStr);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 测试通过决定书编号查询加密驾驶证违章信息
//	 */
////	@Test
//	public void queryEnViolationByJdsbh(){
//		try {
//			ViolationEn violation = new ViolationEn();
//			violation.setJdsbh(SecurityUtil.md5("350100060004977"));
//			String jsonStr4 = JSON.toJSONString(violation);
//			ViolationWebService violationWebService = (ViolationWebService)context.getBean("violationWebService"); // 获取远程服务代理
//			
//			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonStr4.getBytes(), KeyStoreRSA.INTERFACE_PUBLIC_KEY);
//			String sign = RSAUtils.sign(encrypt, KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//	        SecurityMsg securityMsg = new SecurityMsg();
//	        securityMsg.setSignature(sign);
//	        securityMsg.setDigest(encrypt);
//	        String jsonStr = JSON.toJSONString(securityMsg);
//	        
//			String fourJSON = violationWebService.queryEnViolationByJdsbh(jsonStr);
//			
//			SecurityMsg sMsg = JSON.parseObject(fourJSON, SecurityMsg.class);
//			boolean isOK = RSAUtils.verify(sMsg.getDigest(), KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
//			System.out.println("isOK:"+isOK);
//			System.out.println("sMsg.getDigest():"+sMsg.getDigest());
//			byte[] decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(), KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//			String outputStr = new String(decrypt,"gbk");
//			System.out.println("outputStr:"+outputStr);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	/**
//	 * 通过驾驶证号查询加密的驾驶证违章信息
//	 */
////	@Test
//	public void queryEnViolationByJszh(){
//		try {
//			String jszh_md5 = SecurityUtil.md5("350212198309013057");
//			System.out.println("jszh_md5="+jszh_md5);
//			ViolationEn violation = new ViolationEn();
//			violation.setJszh(jszh_md5);
//			violation.setPage(1);
//			violation.setPageSize(2);
//			String jsonStr4 = JSON.toJSONString(violation);
//			ViolationWebService violationWebService = (ViolationWebService)context.getBean("violationWebService"); // 获取远程服务代理
//			
//			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonStr4.getBytes(), KeyStoreRSA.INTERFACE_PUBLIC_KEY);
//			String sign = RSAUtils.sign(encrypt, KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//			SecurityMsg securityMsg = new SecurityMsg();
//			securityMsg.setSignature(sign);
//			securityMsg.setDigest(encrypt);
//			String jsonStr = JSON.toJSONString(securityMsg);
//			
//			String fourJSON = violationWebService.queryEnViolationByJszh(jsonStr);
//			
//			SecurityMsg sMsg = JSON.parseObject(fourJSON, SecurityMsg.class);
//			boolean isOK = RSAUtils.verify(sMsg.getDigest(), KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
//			System.out.println("isOK:"+isOK);
//			System.out.println("sMsg.getDigest():"+sMsg.getDigest());
//			byte[] decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(), KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//			String outputStr = new String(decrypt,"gbk");
//			System.out.println("outputStr:"+outputStr);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 通过号牌号码查询加密机动车违法信息
//	 */
////	@Test
//	public void queryEnViolateByHphm(){
//		try {
//			String hphm_md5 = SecurityUtil.md5("辽DR6368");
//			System.out.println("hphm_md5="+hphm_md5);
//			VehicleViolateEn vehVioEn = new VehicleViolateEn();
//			vehVioEn.setHphm(hphm_md5);
//			vehVioEn.setClbj(SecurityUtil.md5("0"));
////			vehVioEn.setFdjh("J50142");
////			vehVio.setHpzl("02");
//			vehVioEn.setPage(1);
//			vehVioEn.setPageSize(2);
//			String jsonStr1 = JSON.toJSONString(vehVioEn);
//			VehicleViolationWebService vehVioService = (VehicleViolationWebService)context.getBean("vehicleViolationWebService"); // 获取远程服务代理
//			
//			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonStr1.getBytes(), KeyStoreRSA.INTERFACE_PUBLIC_KEY);
//			String sign = RSAUtils.sign(encrypt, KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//	        SecurityMsg securityMsg = new SecurityMsg();
//	        securityMsg.setSignature(sign);
//	        securityMsg.setDigest(encrypt);
//	        String jsonSt1 = JSON.toJSONString(securityMsg);
//	        
//	        String oneJSON = vehVioService.queryEnViolateByHphm(jsonSt1);
//	        System.out.println("oneJSON:"+oneJSON);
//			
//			SecurityMsg sMsg = JSON.parseObject(oneJSON, SecurityMsg.class);
//			boolean isOK = RSAUtils.verify(sMsg.getDigest(), KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
//			System.out.println("isOK:"+isOK);
//			System.out.println("sMsg.getDigest():"+sMsg.getDigest());
//			byte[] decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(), KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//			String outputStr = new String(decrypt,"gbk");
//			System.out.println("outputStr:"+outputStr);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	/**
//	 * 机动与驾驶证违法联合处理加密数据
//	 */
//	@Test
//	public void queryEnViolationComplex(){
//		try {
//			ViolationComplex vic = new ViolationComplex();
//			vic.setHphm(SecurityUtil.md5("辽DR6368"));
//			vic.setClbj(SecurityUtil.md5("0"));
//			vic.setJkbj(SecurityUtil.md5("0"));
////			vehVio.setHpzl("02");
//			String jsonStr0 = JSON.toJSONString(vic);
//			ViolationComplexWebService vicService = (ViolationComplexWebService)context.getBean("violationComplexWebService"); // 获取远程服务代理
//			
//			byte[] encrypt = RSAUtils.encryptByPublicKey(jsonStr0.getBytes(), KeyStoreRSA.INTERFACE_PUBLIC_KEY);
//			String sign = RSAUtils.sign(encrypt, KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//	        SecurityMsg securityMsg = new SecurityMsg();
//	        securityMsg.setSignature(sign);
//	        securityMsg.setDigest(encrypt);
//	        String jsonSt0 = JSON.toJSONString(securityMsg);
//	        
//	        String json = vicService.queryEnViolationComplex(jsonSt0);
//	        System.out.println("JSON:"+json);
//			
//			SecurityMsg sMsg = JSON.parseObject(json, SecurityMsg.class);
//			boolean isOK = RSAUtils.verify(sMsg.getDigest(), KeyStoreRSA.INTERFACE_PUBLIC_KEY, sMsg.getSignature());
//			System.out.println("isOK:"+isOK);
//			System.out.println("sMsg.getDigest():"+sMsg.getDigest());
//			byte[] decrypt = RSAUtils.decryptByPrivateKey(sMsg.getDigest(), KeyStoreRSA.APPSERVER_PRIVATE_KEY);
//			String outputStr = new String(decrypt,"gbk");
//			System.out.println("outputStr:"+outputStr);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
