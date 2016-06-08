package com.ehualu.rise.service.sms.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ehualu.cms.pojo.admin.User;
import com.ehualu.rise.constants.AppConstant;
import com.ehualu.rise.dao.sms.SmsRecordDao;
import com.ehualu.rise.page.PageBoundsUtil;
import com.ehualu.rise.page.Pager;
import com.ehualu.rise.pojo.sms.SmsRecord;
import com.ehualu.rise.property.PropertyConfig;
import com.ehualu.rise.service.sms.SmsService;
import com.ehualu.rise.util.DateUtil;
import com.ehualu.rise.util.SmsUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 短信发送
 * 
 * @author Administrator
 * 
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {

	private static final Logger logger = Logger.getLogger(SmsServiceImpl.class);

	private SmsRecordDao smsRecordDao;

	public SmsRecordDao getSmsRecordDao() {
		return smsRecordDao;
	}

	@Inject
	public void setSmsRecordDao(SmsRecordDao smsRecordDao) {
		this.smsRecordDao = smsRecordDao;
	}

	/**
	 * 短信发送
	 * 
	 * @param phone
	 * @param msg
	 * @return
	 */
	public int sendSmsEhualu(String phone, String msg) {
		int flag = 0;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 您的验证码是236598，请于3分钟内正确输入，收到信息的请在QQ上回一声【易华录】
			StringBuilder sb = new StringBuilder();
			sb.append(PropertyConfig.getProperty("SMS_URL")).append("?cpid=")
					.append(PropertyConfig.getProperty("SMS_ID"))
					.append("&cppwd=")
					.append(PropertyConfig.getProperty("SMS_PWD"))
					.append("&phone=").append(phone).append("&msgcont=")
					.append(URLEncoder.encode(msg, "gb2312"));
			HttpGet httpget = new HttpGet(sb.toString());
			logger.info("执行短信发送: " + httpget.getURI());
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			logger.info("--------------------------------------");
			// 打印响应状态
			logger.info(response.getStatusLine());
			if (entity != null) {
				// 打印响应内容长度
				logger.info("响应内容长度: " + entity.getContentLength());
				// 打印响应内容
				logger.info("响应内容: " + EntityUtils.toString(entity));
			}
			flag = Integer.valueOf(EntityUtils.toString(entity));
			logger.info("------------------------------------");
		} catch (ClientProtocolException e) {
			flag = -1;
			e.printStackTrace();
			return flag;
		} catch (ParseException e) {
			flag = -1;
			e.printStackTrace();
			return flag;
		} catch (IOException e) {
			flag = -1;
			e.printStackTrace();
			return flag;
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				flag = -1;
				e.printStackTrace();
				return flag;
			}
		}
		return flag;

	}

	@Override
	public String sendSmsEmay(SmsRecord record) {
		String result = SmsUtil.sendSms(record.getContent(), record.getPhone());
		InputStream inputStream = SmsUtil.class.getClassLoader()
				.getResourceAsStream("smserror.properties");
		Properties smserror = new Properties();
		try {
			smserror.load(inputStream);
			String returnValue = smserror.getProperty(result);
			if(returnValue == null || !"".equals(returnValue)){
				returnValue = "发送失败";
			}
			record.setReturnvalue(returnValue);
			record.setTime(DateUtil.getTimestamp());
			smsRecordDao.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		SmsServiceImpl sms = new SmsServiceImpl();
		int flag = sms.sendSmsEhualu("18101135210",
				PropertyConfig.getProperty("SMS_MSG"));
		System.out.println("flag:" + flag);
	}

	@Override
	public Pager<SmsRecord> findSmsRecord() {
		// 获取用户总数
		//int count = userDao.findUserCount();
		int count = smsRecordDao.findSmsRecordCount();
		// 封装PageBounds对象
		PageBounds pageBounds = PageBoundsUtil
				.PageBoundsOrderExtend("time.desc");
		// 获取用户分页列表集合信息
		//List<User> list = userDao.findUser(pageBounds);
		List<SmsRecord> list = smsRecordDao.findSmsRecord(pageBounds);
		// 封装用户分页的Pager对象
		Pager<SmsRecord> pages = new Pager<SmsRecord>(count, list);
		return pages;
	}

}
