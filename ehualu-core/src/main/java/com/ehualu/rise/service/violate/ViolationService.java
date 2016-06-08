package com.ehualu.rise.service.violate;

import com.ehualu.rise.pojo.msg.Msg;

/**
 * 驾驶证违法信息接口
 * @author Administrator
 *
 */
public interface ViolationService {

	/**
	 * 查询驾驶证违法(通过时间点，结果集数量)
	 * @param paramJson
	 * @return
	 */
	public Msg queryViolationByJszh(String paramJson);
	
	/**
	 * 通过决定书编号查询加密的驾驶证违章信息
	 * @param paramJson
	 * @return
	 */
	public Msg queryEnViolationByJdsbh(String paramJson);
	
	/**
	 * 通过驾驶证号查询加密的驾驶证违法信息
	 * @param paramJson
	 * @return
	 */
	public Msg queryEnViolationByJszh(String paramJson);
}
