package com.ehualu.rise.dao.violate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ehualu.rise.pojo.violate.VehicleViolate;
import com.ehualu.rise.pojo.violate.VehicleViolateEn;
import com.ehualu.rise.pojo.violate.ViolationComplex;
import com.ehualu.rise.pojo.violate.ViolationComplexEn;

/**
 * 
 * @author Administrator
 * 车辆违法表
 */
public interface VehicleViolateDao {

	/**
	 * 根据号牌号码和号牌种类查询车辆违章信息
	 * @param hphm
	 * @param hpzl
	 * @return
	 */
	public List<VehicleViolate> queryByHphm(@Param("hphm") String hphm);
	
	/**
	 * 根据号牌号码查询机动车违法(通过时间点，结果集数量)
	 * @param vehicleViolate
	 * @return
	 */
	public List<VehicleViolate> queryViolateByHphm(VehicleViolate vehicleViolate);
	
	/**
	 * 通过号牌号码和处理比较查询(未处理车辆)
	 * @param violationComplex
	 * @return
	 */
	public List<ViolationComplex>  queryViolateByHphmClbj(ViolationComplex violationComplex);
	
	/**
	 * 通过号牌号码查询加密机动车违法信息参数为对象
	 * @param vehicleViolateEn
	 * @return
	 */
	public List<VehicleViolateEn> queryEnViolateByHphm(VehicleViolateEn vehicleViolateEn);
	
	/**
	 * 通过号牌号码和处理标记查询加密机动车违法信息
	 * @param violationComplexEn
	 * @return
	 */
	public List<ViolationComplexEn> queryEnViolateByHphmClbj(ViolationComplexEn violationComplexEn);
}
