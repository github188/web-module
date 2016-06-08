package com.ehualu.rise.service.violate;

import com.ehualu.rise.pojo.msg.Msg;

/**
 * 机动车信息接口
 * @author Administrator
 *
 */
public interface VehicleService {

	/**
	 * 通过号牌查询机动车
	 * @param paramJson
	 * @return
	 */
	public Msg queryVehicleByHphm(String paramJson);
	
	/**
	 * 通过号牌查询加密机动车
	 * @param paramJson
	 * @return
	 */
	public Msg queryEnVehicleByHphm(String paramJson);
}
