package com.ehualu.rise.service.sms;

import com.ehualu.rise.page.Pager;
import com.ehualu.rise.pojo.sms.SmsRecord;

public interface SmsService {

	/**
	 * 短信发送(华录亿动)
	 * @param phone
	 * @param msg
	 * @return
	 */
	public int sendSmsEhualu(String phone,String msg);
	
	/**
	 * 短信发送(亿美软通)
	 * @param phone
	 * @param msg
	 * @return
	 */
	public String sendSmsEmay(SmsRecord record);
	
	/**
	 * 
	 * @return
	 */
	public Pager<SmsRecord> findSmsRecord();
}
