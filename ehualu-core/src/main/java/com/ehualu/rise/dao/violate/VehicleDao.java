package com.ehualu.rise.dao.violate;

import com.ehualu.rise.pojo.violate.Vehicle;
import com.ehualu.rise.pojo.violate.VehicleEn;

/**
 * 机动车Dao接口
 * @author Administrator
 *
 */
public interface VehicleDao {

	/**
	 * 通过号牌查询机动车
	 * @param vehicle
	 * @return
	 */
	public Vehicle queryVehicleByHphm(Vehicle vehicle);
	
	/**
	 * 通过号牌查询加密机动车信息
	 * @param vehicleEn
	 * @return
	 */
	public VehicleEn queryEnVehicleByHphm(VehicleEn vehicleEn);
}
