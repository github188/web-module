package com.ehualu.rise.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import org.dom4j.Element;

public class SmsUtil {

	public static final String MARK = "|";

	public static final String ext = "";

	public static final String rrid = "";

	public static final String stime = "";

	public static final String stype = "1";

	public static final String ssafe = "2";

	public static final String scode = "1"; // 1表示UTF-8，2表示GB2312

	public static final String Md5key = "abcdef";

	public static final String ssl = "2";

	/**
	 * 发送短信
	 * 
	 * @param content
	 * @param phone
	 * @return 错误码：-1:用户名不存在 -2:密码错误 -3:余额不足 -4:系统正忙，请稍后重试 -5:通道id错误 -7:内容黑词
	 *         -8:账号冻结 -9: 下发异常 -10:接口异常 -70:调用异常
	 */
	public static String sendSms(String content, String phone) {
		InputStream inputStream = SmsUtil.class.getClassLoader()
				.getResourceAsStream("smsclient.properties");
		Properties smsclient = new Properties();
		StringBuffer sb = new StringBuffer();
		try {
			smsclient.load(inputStream);

			System.out.println("url:" + smsclient.getProperty("url")
					+ ",cdkey:" + smsclient.getProperty("cdkey") + ",password:"
					+ smsclient.getProperty("password"));
			String url = smsclient.getProperty("url");
			String cdkey = smsclient.getProperty("cdkey");
			String password = smsclient.getProperty("password");
			StringBuffer result = new StringBuffer();
			result.append(url);
			result.append("?cdkey=" + cdkey);// 用户名
			result.append("&password=" + password);// 密码
			result.append("&phone=" + phone);// 手机号码
			result.append("&message=" + URLEncoder.encode(content, "utf-8"));// 短信内容
			URL finalurl = new URL(result.toString());
			HttpURLConnection connection = (HttpURLConnection) finalurl
					.openConnection();
			connection.setRequestProperty("user-agent",
					"mozilla/4.0 (compatible; msie 6.0; windows 2000)");
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(30000);
			connection.connect();
			System.out.println("--debug myurl:" + result.toString()
					+ ",length:" + connection.getContentLength() + ",status:"
					+ connection.getResponseCode());
			if (connection.getResponseCode() == 200) {
				InputStream in = connection.getInputStream();
				BufferedReader breader = new BufferedReader(
						new InputStreamReader(in, "gbk"));
				String str = breader.readLine();
				while (str != null) {
					sb.append(str);
					str = breader.readLine();
				}
				in.close();
			}
			connection.disconnect();
			connection = null;
			finalurl = null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root = XmlUtil.getRoot(sb.toString());
		String result = XmlUtil.getErrMsg(root);
		return result;
	}

	/**
	 * 发送短信
	 * 
	 * @param content
	 * @param phone
	 * @return 错误码：-1:用户名不存在 -2:密码错误 -3:余额不足 -4:系统正忙，请稍后重试 -5:通道id错误 -7:内容黑词
	 *         -8:账号冻结 -9: 下发异常 -10:接口异常 -70:调用异常
	 */
	public static String sendSmsSuDa(String content, String phone) {
		StringBuffer sb = new StringBuffer();
	   try {
//			InputStream inputStream = SmsUtil.class.getClassLoader()
//					.getResourceAsStream("smsclient.properties");
//			Properties smsclient = new Properties();
//			smsclient.load(inputStream);
//			String url = smsclient.getProperty("sudaurl");
//			String sn = smsclient.getProperty("sn");
//			String pwd = smsclient.getProperty("pwd");
		    String url = "http://sdk8.interface.sudas.cn/z_mdsmssend.php";
		    String sn= "SUD-KEY-001-192";
		    String pwd = "CC03E747A6AFBBCBF8BE7668ACFEBEE5";
			String signInfo = sn + MARK + pwd + MARK + phone + MARK + content
					+ MARK + ext + MARK + rrid + MARK + stime + MARK + stype
					+ MARK + ssafe + MARK + scode + MARK + Md5key;
			String Md5Sign = getMD5(signInfo);
			StringBuffer param = new StringBuffer();
			param.append(url);
			param.append("?sn="+sn);
			param.append("&pwd="+pwd);
			param.append("&mobile="+phone);
			param.append("&content="+URLEncoder.encode(content, "utf-8"));
			param.append("&ext="+ext);
			param.append("&rrid="+rrid);
			param.append("&stime="+stime);
			param.append("&stype="+stype);
			param.append("&ssafe="+ssafe);
			param.append("&scode="+scode);
			param.append("&ssl="+ssl);
			param.append("&Md5key="+Md5key);
			param.append("&Md5Sign="+Md5Sign);
			URL finalurl = new URL(param.toString());
			HttpURLConnection connection = (HttpURLConnection) finalurl
					.openConnection();
			connection.setRequestProperty("user-agent",
					"mozilla/4.0 (compatible; msie 6.0; windows 2000)");
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(30000);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type",
					"application/json;charset=UTF-8");
			connection.connect();
			System.out.println("--debug myurl:" + url + ",length:"
					+ connection.getContentLength() + ",status:"
					+ connection.getResponseCode());
			if (connection.getResponseCode() == 200) {
				InputStream in = connection.getInputStream();
				BufferedReader breader = new BufferedReader(
						new InputStreamReader(in, "utf-8"));
				String str = breader.readLine();
				while (str != null) {
					sb.append(str);
					str = breader.readLine();
				}
				in.close();
			}
			connection.disconnect();
			connection = null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	   return sb.toString();

	}

	public static String getMD5(String sourceStr)
			throws UnsupportedEncodingException {
		String resultStr = "";
		try {
			byte[] temp = sourceStr.getBytes();

			MessageDigest md5 = MessageDigest.getInstance("MD5");

			md5.update(temp);

			// resultStr = new String(md5.digest());
			byte[] b = md5.digest();

			for (int i = 0; i < b.length; i++) {

				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8',

				'9', 'A', 'B', 'C', 'D', 'E', 'F' };

				char[] ob = new char[2];

				ob[0] = digit[(b[i] >>> 4) & 0X0F];

				ob[1] = digit[b[i] & 0X0F];

				resultStr += new String(ob);

			}

			return resultStr;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;

		}

	}
	
	public static void main(String[] args){
		String content = "您好。您的验证码为395959。请及时操作！【索美科技】";
		String phone = "18101135114";
		
		String result = sendSmsSuDa(content,phone);
		
		System.out.println(result);
	}

}
