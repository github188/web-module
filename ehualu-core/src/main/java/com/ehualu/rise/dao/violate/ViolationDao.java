package com.ehualu.rise.dao.violate;

import java.util.List;

import com.ehualu.rise.pojo.violate.Violation;
import com.ehualu.rise.pojo.violate.ViolationComplex;
import com.ehualu.rise.pojo.violate.ViolationComplexEn;
import com.ehualu.rise.pojo.violate.ViolationEn;

/**
 * 驾驶证违法Dao接口
 * @author Administrator
 *
 */
public interface ViolationDao {

	/**
	 * 查询驾驶证违法(通过时间点，结果集数量)
	 * @param violation
	 * @return
	 */
	public List<Violation> queryViolationByJszh(Violation violation);
	
	/**
	 * 通过号牌号码查询驾驶证违法信息(未交款)
	 * @param violationComplex
	 * @return
	 */
	public List<ViolationComplex> queryViolationByHphm(ViolationComplex violationComplex);
	
	
	/**
	 * 通过决定书编号查询加密的驾驶证违章信息
	 * @param violationEn
	 * @return
	 */
	public ViolationEn queryEnViolationByJdsbh(ViolationEn violationEn);
	
	/**
	 * 通过驾驶证号查询加密的驾驶证违法信息
	 * @param violationEn
	 * @return
	 */
	public List<ViolationEn> queryEnViolationByJszh(ViolationEn violationEn);
	
	/**
	 * 通过号牌号码查询加密驾驶证违法信息,交款标记为未交款
	 * @param violationComplexEn
	 * @return
	 */
	public List<ViolationComplexEn> queryEnViolationByHphm(ViolationComplexEn violationComplexEn);
}
