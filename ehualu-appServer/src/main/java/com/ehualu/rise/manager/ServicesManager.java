package com.ehualu.rise.manager;

import java.util.Map;

import com.ehualu.rise.service.ServiceInterface;

/**
 * 业务代码映射类
 * @author Administrator
 *
 */
public class ServicesManager {

	/**
	 * 协议代码业务类映射
	 */
	private Map<String, ServiceInterface> map;

	public Map<String, ServiceInterface> getMap() {
		return map;
	}

	public void setMap(Map<String, ServiceInterface> map) {
		this.map = map;
	}
}
