package com.ehualu.rise.pojo.violate;

import java.io.Serializable;
/**
 * 机动车违法和驾驶证违法加密数据联合查询
 * @author Administrator
 *
 */
public class ViolationComplexEn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7009757686496831164L;

	private String xh;//序号
	
	private String tzsh;//通知书号

	private String wfbh;//违法编号
	
	private String jdsbh;//决定书编号  
	
	private String jdslb;//决定书类别  
	
	private String lxfs;//联系方式  
	
	private String hpzl;//号牌种类  
	
	private String jdcsyr;//机动车所有人  
	
	private String jszh;//驾驶证号
	
	private String hphm;//号牌号码  
	
	private String wfdd;//违法地点  
	
	private String wfdz;//违法地址  
	
	private String wfsj;//违法时间  
	
	private String wfxw;//违法行为
	
	private String xzqh;//行政区划  
	
	private String dsr;//当事人  
	
	private String fzjg;//发证机关  
	
	private String clsj;//处理时间  
	
	private String fkje;//罚款金额  
	
	private String cjjg;//采集机关  
	
	private String wfjfs;//违法记分数  
	
	private String fdjh;//发动机号  
	
	private String clbj;//处理标记  
	
	private String clsbdh;//车辆识别代号
	
	private String lrsj;//录入时间
	
	private String xxly;//信息来源
	
	private String znj;//滞纳金
	
	private String yfznj;//应付滞纳金
	
	private String jkfs;//缴款方式
	
	private String cljg;//处理机关
	
	private String fxjg;//发现机关
	
	private String cfzl;//处罚种类
	
	private String jkbj;//缴款标记
	
	private String jsjg;//接收机关
	
	private String gxsj;//更新时间
	
	private String sjly;//数据来源0=sur(机动车违法),1=vio(驾驶证违法)

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getTzsh() {
		return tzsh;
	}

	public void setTzsh(String tzsh) {
		this.tzsh = tzsh;
	}

	public String getWfbh() {
		return wfbh;
	}

	public void setWfbh(String wfbh) {
		this.wfbh = wfbh;
	}

	public String getJdsbh() {
		return jdsbh;
	}

	public void setJdsbh(String jdsbh) {
		this.jdsbh = jdsbh;
	}

	public String getJdslb() {
		return jdslb;
	}

	public void setJdslb(String jdslb) {
		this.jdslb = jdslb;
	}

	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	public String getHpzl() {
		return hpzl;
	}

	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}

	public String getJdcsyr() {
		return jdcsyr;
	}

	public void setJdcsyr(String jdcsyr) {
		this.jdcsyr = jdcsyr;
	}

	public String getJszh() {
		return jszh;
	}

	public void setJszh(String jszh) {
		this.jszh = jszh;
	}

	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public String getWfdd() {
		return wfdd;
	}

	public void setWfdd(String wfdd) {
		this.wfdd = wfdd;
	}

	public String getWfdz() {
		return wfdz;
	}

	public void setWfdz(String wfdz) {
		this.wfdz = wfdz;
	}

	public String getWfsj() {
		return wfsj;
	}

	public void setWfsj(String wfsj) {
		this.wfsj = wfsj;
	}

	public String getWfxw() {
		return wfxw;
	}

	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getDsr() {
		return dsr;
	}

	public void setDsr(String dsr) {
		this.dsr = dsr;
	}

	public String getFzjg() {
		return fzjg;
	}

	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}

	public String getClsj() {
		return clsj;
	}

	public void setClsj(String clsj) {
		this.clsj = clsj;
	}

	public String getFkje() {
		return fkje;
	}

	public void setFkje(String fkje) {
		this.fkje = fkje;
	}

	public String getCjjg() {
		return cjjg;
	}

	public void setCjjg(String cjjg) {
		this.cjjg = cjjg;
	}

	public String getWfjfs() {
		return wfjfs;
	}

	public void setWfjfs(String wfjfs) {
		this.wfjfs = wfjfs;
	}

	public String getFdjh() {
		return fdjh;
	}

	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}

	public String getClbj() {
		return clbj;
	}

	public void setClbj(String clbj) {
		this.clbj = clbj;
	}

	public String getClsbdh() {
		return clsbdh;
	}

	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}

	public String getLrsj() {
		return lrsj;
	}

	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}

	public String getXxly() {
		return xxly;
	}

	public void setXxly(String xxly) {
		this.xxly = xxly;
	}

	public String getZnj() {
		return znj;
	}

	public void setZnj(String znj) {
		this.znj = znj;
	}

	public String getYfznj() {
		return yfznj;
	}

	public void setYfznj(String yfznj) {
		this.yfznj = yfznj;
	}

	public String getJkfs() {
		return jkfs;
	}

	public void setJkfs(String jkfs) {
		this.jkfs = jkfs;
	}

	public String getCljg() {
		return cljg;
	}

	public void setCljg(String cljg) {
		this.cljg = cljg;
	}

	public String getFxjg() {
		return fxjg;
	}

	public void setFxjg(String fxjg) {
		this.fxjg = fxjg;
	}

	public String getCfzl() {
		return cfzl;
	}

	public void setCfzl(String cfzl) {
		this.cfzl = cfzl;
	}

	public String getJkbj() {
		return jkbj;
	}

	public void setJkbj(String jkbj) {
		this.jkbj = jkbj;
	}

	public String getJsjg() {
		return jsjg;
	}

	public void setJsjg(String jsjg) {
		this.jsjg = jsjg;
	}

	public String getGxsj() {
		return gxsj;
	}

	public void setGxsj(String gxsj) {
		this.gxsj = gxsj;
	}

	public String getSjly() {
		return sjly;
	}

	public void setSjly(String sjly) {
		this.sjly = sjly;
	}
}
