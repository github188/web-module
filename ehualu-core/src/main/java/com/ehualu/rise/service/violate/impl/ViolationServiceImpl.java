package com.ehualu.rise.service.violate.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ehualu.rise.constants.InterfaceConstant;
import com.ehualu.rise.dao.violate.ViolationDao;
import com.ehualu.rise.pojo.msg.Msg;
import com.ehualu.rise.pojo.violate.Violation;
import com.ehualu.rise.pojo.violate.ViolationEn;
import com.ehualu.rise.property.PropertyConfig;
import com.ehualu.rise.service.violate.ViolationService;
import com.ehualu.rise.util.SecurityUtil;
/**
 * 驾驶证违法信息接口实现
 * @author Administrator
 *
 */
@Service("violationServiceImpl")
public class ViolationServiceImpl implements ViolationService {

	private static final Logger logger = Logger.getLogger(ViolationServiceImpl.class);
	
	private ViolationDao violationDao;

	public ViolationDao getViolationDao() {
		return violationDao;
	}

	@Inject
	public void setViolationDao(ViolationDao violationDao) {
		this.violationDao = violationDao;
	}
	
	/**
	 * 查询驾驶证违法(通过时间点，结果集数量)
	 * @param paramJson
	 * @return
	 */
	public Msg queryViolationByJszh(String paramJson){
		logger.info("paramJson:"+paramJson);
		
		Violation violation = JSON.parseObject(paramJson, Violation.class);
		Msg msg = new Msg();
		//判断参数是否为空
		if(violation == null){
			msg.setStatuCode(InterfaceConstant.PARAM_IS_NULL);
			msg.setMsgBody(PropertyConfig.getProperty("PARAM_IS_NULL"));
			
			logger.info("violation == null"+JSON.toJSONString(msg));
			return msg;
		}
		//判断驾驶证号是否为空
		if(violation.getJszh() == null || (violation.getJszh()).equals("")){
			msg.setStatuCode(InterfaceConstant.Code_004.VIOLATION_JSZH_IS_NULL);
			msg.setMsgBody(PropertyConfig.getProperty("VIOLATION_JSZH_IS_NULL"));
			
			logger.info("violation.getJszh() == null"+JSON.toJSONString(msg));
			return msg;
		}
		
		//查询驾驶证违法信息
		List<Violation> list = violationDao.queryViolationByJszh(violation);
		if(list.size() == 0){
			msg.setStatuCode(InterfaceConstant.RESULT_IS_NULL);
			msg.setMsgBody(PropertyConfig.getProperty("RESULT_IS_NULL"));
			logger.info("violation is null:"+JSON.toJSONString(msg));
			return msg;
		}
		msg.setStatuCode(InterfaceConstant.STATU_SUCCESS);
		msg.setMsgBody(list);
		logger.info("RESULT:"+JSON.toJSONString(msg));
		return msg;
	}
	
	/**
	 * 通过决定书编号查询加密的驾驶证违章信息
	 * @param paramJson
	 * @return
	 */
	public Msg queryEnViolationByJdsbh(String paramJson){
		logger.info("paramJson:"+paramJson);
		
		ViolationEn violationEn = JSON.parseObject(paramJson, ViolationEn.class);
		Msg msg = new Msg();
		//判断参数是否为空
		if(violationEn == null){
			msg.setStatuCode(InterfaceConstant.PARAM_IS_NULL);
			msg.setMsgBody(PropertyConfig.getProperty("PARAM_IS_NULL"));
			
			logger.info("PARAM IS NULL:"+JSON.toJSONString(msg));
			return msg;
		}
		//判断驾驶证号是否为空
		if(violationEn.getJdsbh() == null || (violationEn.getJdsbh()).equals("")){
			msg.setStatuCode(InterfaceConstant.Code_004.VIOLATION_JDSBH_IS_NULL);
			msg.setMsgBody(PropertyConfig.getProperty("VIOLATION_JDSBH_IS_NULL"));
			
			logger.info("VIOLATION JDSBH IS NULL:"+JSON.toJSONString(msg));
			return msg;
		}
		
		//查询驾驶证违法信息
		ViolationEn vle = violationDao.queryEnViolationByJdsbh(violationEn);
		
		if(vle == null){
			msg.setStatuCode(InterfaceConstant.RESULT_IS_NULL);
			msg.setMsgBody(PropertyConfig.getProperty("RESULT_IS_NULL"));
			logger.info("RESULT IS NULL:"+JSON.toJSONString(msg));
			return msg;
		}
		//数据类型转换
		Violation viol = createViolation(vle);
		msg.setStatuCode(InterfaceConstant.STATU_SUCCESS);
		msg.setMsgBody(viol);
		logger.info("RESULT:"+JSON.toJSONString(msg));
		return msg;
	}
	
	/**
	 * 通过驾驶证号查询加密的驾驶证违法信息
	 * @param paramJson
	 * @return
	 */
	public Msg queryEnViolationByJszh(String paramJson){
		logger.info("paramJson:"+paramJson);
		
		ViolationEn violationEn = JSON.parseObject(paramJson, ViolationEn.class);
		Msg msg = new Msg();
		//判断参数是否为空
		if(violationEn == null){
			msg.setStatuCode(InterfaceConstant.PARAM_IS_NULL);
			msg.setMsgBody(PropertyConfig.getProperty("PARAM_IS_NULL"));
			
			logger.info("PARAM IS NULL:"+JSON.toJSONString(msg));
			return msg;
		}
		//判断驾驶证号是否为空
		if(violationEn.getJszh() == null || (violationEn.getJszh()).equals("")){
			msg.setStatuCode(InterfaceConstant.Code_004.VIOLATION_JSZH_IS_NULL);
			msg.setMsgBody(PropertyConfig.getProperty("VIOLATION_JSZH_IS_NULL"));
			
			logger.info("VIOLATION JSZH IS NULL:"+JSON.toJSONString(msg));
			return msg;
		}
		
		//查询驾驶证违法信息
		List<ViolationEn> listEn = violationDao.queryEnViolationByJszh(violationEn);
		if(listEn.size() == 0){
			msg.setStatuCode(InterfaceConstant.RESULT_IS_NULL);
			msg.setMsgBody(PropertyConfig.getProperty("RESULT_IS_NULL"));
			logger.info("RESULT IS NULL:"+JSON.toJSONString(msg));
			return msg;
		}
		//数据类型转换
		List<Violation> list = new ArrayList<Violation>();
		for(int i=0;i<listEn.size();i++){
			Violation violat = createViolation(listEn.get(i));
			list.add(violat);
		}
		msg.setStatuCode(InterfaceConstant.STATU_SUCCESS);
		msg.setMsgBody(list);
		logger.info("RESULT:"+JSON.toJSONString(msg));
		return msg;
	}
	/**
	 * 数据类型转换
	 * @param vlEn
	 * @return
	 */
	private Violation createViolation(ViolationEn vlEn){
		//设置时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//解密秘钥
		String secretKey = PropertyConfig.getProperty("AES_SECRET_KEY");
		
		String wfbhStr = SecurityUtil.decrypt(vlEn.getWfbh(), secretKey);
		String jdslbStr = SecurityUtil.decrypt(vlEn.getJdslb(), secretKey);
		String jdsbhStr = SecurityUtil.decrypt(vlEn.getJdsbh(), secretKey);
		String wsjywStr = SecurityUtil.decrypt(vlEn.getWsjyw(), secretKey);
		String ryflStr = SecurityUtil.decrypt(vlEn.getRyfl(), secretKey);
		String jszhStr = SecurityUtil.decrypt(vlEn.getJszh(), secretKey);
		String dabhStr = SecurityUtil.decrypt(vlEn.getDabh(), secretKey);
		String fzjgStr = SecurityUtil.decrypt(vlEn.getFzjg(), secretKey);
		
		logger.info("wfbhStr="+wfbhStr);
		logger.info("jdslbStr="+jdslbStr);
		logger.info("jdsbhStr="+jdsbhStr);
		logger.info("wsjywStr="+wsjywStr);
		logger.info("ryflStr="+ryflStr);
		logger.info("jszhStr="+jszhStr);
		logger.info("dabhStr="+dabhStr);
		logger.info("fzjgStr="+fzjgStr);
		
		String zjcxStr = SecurityUtil.decrypt(vlEn.getZjcx(), secretKey);
		String dsrStr = SecurityUtil.decrypt(vlEn.getDsr(), secretKey);
		String zsxzqhStr = SecurityUtil.decrypt(vlEn.getZsxzqh(), secretKey);
		String zsxxdzStr = SecurityUtil.decrypt(vlEn.getZsxxdz(), secretKey);
		String dhStr = SecurityUtil.decrypt(vlEn.getDh(), secretKey);
		String lxfsStr = SecurityUtil.decrypt(vlEn.getLxfs(), secretKey);
		String clflStr = SecurityUtil.decrypt(vlEn.getClfl(), secretKey);
		String hpzlStr = SecurityUtil.decrypt(vlEn.getHpzl(), secretKey);
		String hphmStr = SecurityUtil.decrypt(vlEn.getHphm(), secretKey);
		
		logger.info("zjcxStr="+zjcxStr);
		logger.info("dsrStr="+dsrStr);
		logger.info("zsxzqhStr="+zsxzqhStr);
		logger.info("zsxxdzStr="+zsxxdzStr);
		logger.info("dhStr="+dhStr);
		logger.info("lxfsStr="+lxfsStr);
		logger.info("clflStr="+clflStr);
		logger.info("hpzlStr="+hpzlStr);
		logger.info("hphmStr="+hphmStr);
		
		
		String jdcsyrStr = SecurityUtil.decrypt(vlEn.getJdcsyr(), secretKey);
		String syxzStr = SecurityUtil.decrypt(vlEn.getSyxz(), secretKey);
		String jtfsStr = SecurityUtil.decrypt(vlEn.getJtfs(), secretKey);
		String wfsjStr = SecurityUtil.decrypt(vlEn.getWfsj(), secretKey);
		String wfddStr = SecurityUtil.decrypt(vlEn.getWfdd(), secretKey);
		String wfdzStr = SecurityUtil.decrypt(vlEn.getWfdz(), secretKey);
		String wfxwStr = SecurityUtil.decrypt(vlEn.getWfxw(), secretKey);
		String wfjfsStr = SecurityUtil.decrypt(vlEn.getWfjfs(), secretKey);
		String fkjeStr = SecurityUtil.decrypt(vlEn.getFkje(), secretKey);
		String sczStr = SecurityUtil.decrypt(vlEn.getScz(), secretKey);
		String bzzStr = SecurityUtil.decrypt(vlEn.getBzz(), secretKey);
		String znjStr = SecurityUtil.decrypt(vlEn.getZnj(), secretKey);
		
		logger.info("jdcsyrStr="+jdcsyrStr);
		logger.info("syxzStr="+syxzStr);
		logger.info("jtfsStr"+jtfsStr);
		logger.info("wfsjStr="+wfsjStr);
		logger.info("wfddStr="+wfddStr);
		logger.info("wfdzStr="+wfdzStr);
		logger.info("wfxwStr="+wfxwStr);
		logger.info("wfjfsStr="+wfjfsStr);
		logger.info("fkjeStr="+fkjeStr);
		logger.info("sczStr="+sczStr);
		logger.info("bzzStr="+bzzStr);
		logger.info("znjStr="+znjStr);
		
		
		String zqmjStr = SecurityUtil.decrypt(vlEn.getZqmj(), secretKey);
		String jkfsStr = SecurityUtil.decrypt(vlEn.getJkfs(), secretKey);
		String fxjgStr = SecurityUtil.decrypt(vlEn.getFxjg(), secretKey);
		String fxjgmcStr = SecurityUtil.decrypt(vlEn.getFxjgmc(), secretKey);
		String cljgStr = SecurityUtil.decrypt(vlEn.getCljg(), secretKey);
		String cljgmcStr = SecurityUtil.decrypt(vlEn.getCljgmc(), secretKey);
		String cfzlStr = SecurityUtil.decrypt(vlEn.getCfzl(), secretKey);
		String clsjStr = SecurityUtil.decrypt(vlEn.getClsj(), secretKey);
		String jkbjStr = SecurityUtil.decrypt(vlEn.getJkbj(), secretKey);
		String jkrqStr = SecurityUtil.decrypt(vlEn.getJkrq(), secretKey);
		String pzbhStr = SecurityUtil.decrypt(vlEn.getPzbh(), secretKey);
		String jsjqbjStr = SecurityUtil.decrypt(vlEn.getJsjqbj(), secretKey);
		
		
		logger.info("zqmjStr="+zqmjStr);
		logger.info("jkfsStr="+jkfsStr);
		logger.info("fxjgStr"+fxjgStr);
		logger.info("fxjgmcStr="+fxjgmcStr);
		logger.info("cljgStr="+cljgStr);
		logger.info("cljgmcStr="+cljgmcStr);
		logger.info("cfzlStr="+cfzlStr);
		logger.info("clsjStr="+clsjStr);
		logger.info("jkbjStr"+jkbjStr);
		logger.info("jkrqStr="+jkrqStr);
		logger.info("pzbhStr="+pzbhStr);
		logger.info("jsjqbjStr="+jsjqbjStr);
		
		String jllxStr = SecurityUtil.decrypt(vlEn.getJllx(), secretKey);
		String lrrStr = SecurityUtil.decrypt(vlEn.getLrr(), secretKey);
		String jbr1Str = SecurityUtil.decrypt(vlEn.getJbr1(), secretKey);
		String jbr2Str = SecurityUtil.decrypt(vlEn.getJbr2(), secretKey);
		String sgdjStr = SecurityUtil.decrypt(vlEn.getSgdj(), secretKey);
		String xxlyStr = SecurityUtil.decrypt(vlEn.getXxly(), secretKey);
		String xrmsStr = SecurityUtil.decrypt(vlEn.getXrms(), secretKey);
		String jsjgStr = SecurityUtil.decrypt(vlEn.getJsjg(), secretKey);
		String gxsjStr = SecurityUtil.decrypt(vlEn.getGxsj(), secretKey);
		String bzStr = SecurityUtil.decrypt(vlEn.getBz(), secretKey);
		
		
		logger.info("jllxStr="+jllxStr);
		logger.info("lrrStr="+lrrStr);
		logger.info("jbr1Str="+jbr1Str);
		logger.info("jbr2Str="+jbr2Str);
		logger.info("sgdjStr="+sgdjStr);
		logger.info("xxlyStr="+xxlyStr);
		logger.info("xrmsStr="+xrmsStr);
		logger.info("jsjgStr"+jsjgStr);
		logger.info("gxsjStr="+gxsjStr);
		logger.info("bzStr="+bzStr);
		try {
			Violation violation = new Violation(wfbhStr, jdslbStr, jdsbhStr, wsjywStr, 
					ryflStr, jszhStr, dabhStr, fzjgStr, zjcxStr, 
					dsrStr, zsxzqhStr, zsxxdzStr, dhStr, lxfsStr, 
					clflStr, hpzlStr, hphmStr, jdcsyrStr, syxzStr, 
					jtfsStr, sdf.parse(wfsjStr), wfddStr, wfdzStr, wfxwStr, 
					Double.parseDouble((wfjfsStr==null||wfjfsStr.trim().equals("")?"0":wfjfsStr)), Double.parseDouble((fkjeStr==null||fkjeStr.trim().equals("")?"0":fkjeStr)), Double.parseDouble((sczStr==null||sczStr.trim().equals("")?"0":sczStr)), Double.parseDouble((bzzStr==null||bzzStr.trim().equals("")?"0":bzzStr)), Double.parseDouble((znjStr==null||znjStr.trim().equals("")?"0":znjStr)), 
					zqmjStr, jkfsStr, fxjgStr, fxjgmcStr, cljgStr, 
					cljgmcStr, cfzlStr, sdf.parse(clsjStr), jkbjStr, sdf.parse(jkrqStr), 
					pzbhStr, jsjqbjStr, jllxStr, lrrStr, sdf.parse(vlEn.getLrsj()), 
					jbr1Str, jbr2Str, sgdjStr, xxlyStr, xrmsStr, 
					jsjgStr, sdf.parse(gxsjStr), bzStr);
			return violation;
		} catch (Exception e) {
			logger.info(e);
			return null;
		}
	}
}
