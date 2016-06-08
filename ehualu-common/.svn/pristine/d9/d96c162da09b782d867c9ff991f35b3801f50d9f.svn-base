package com.ehualu.rise.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * interface中MAP转JSON
 * @author Administrator
 *
 */
public class MapParseJSON {

	/**
	 * map转json
	 * @param code
	 * @param jsonStr
	 * @return
	 */
	public static String mapParseJson(String code,String jsonStr){
		Map<String,String> map = new HashMap<String,String>();
		map.put(code, jsonStr);
		return JSON.toJSONString(map);
	}
}
