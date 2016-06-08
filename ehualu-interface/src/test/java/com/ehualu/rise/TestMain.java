package com.ehualu.rise;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class TestMain {

	private static Map paramMap = new HashMap() {
		{
//			// 登录
//			put("login",
//					"head={\"xyh\":\"0101\",\"ztm\":\"000\"}&body={\"phone\":\"18622927505\",\"password\":\"654321\",\"mac\":\"123\",\"mfrs\":\"123\",\"model\":\"123\"}");
//
//			// 登出
//			put("logout",
//					"head={\"xyh\":\"0106\",\"ztm\":\"000\"}&body={\"phone\":\"18622927505\",\"mac\":\"123\",\"mfrs\":\"123\",\"model\":\"123\"}");
//
//			// 修改密码
//			put("changePassword",
//					"head={\"xyh\":\"0102\",\"ztm\":\"000\"}&body={\"phone\":\"18622927505\",\"password\":\"123456\",\"newPassword\":\"123\"}");
//
//			// 用户注册
//			put("userRegister",
//					"head={\"xyh\":\"0103\",\"ztm\":\"000\"}&body={\"phone\":\"18622927505\",\"nick\":\"bright\",\"password\":\"123456\",\"authenCode\":\"415127\"}");
//
//			// 重置密码
//			put("resetPassword",
//					"head={\"xyh\":\"0105\",\"ztm\":\"000\"}&body={\"phone\":\"18622927505\",\"newPassword\":\"654321\",\"authenCode\":\"131646\"}");
//
//			// 验证码发送
//			put("sendVerificationCode",
//					"head={\"xyh\":\"0104\",\"ztm\":\"000\"}&body={\"phone\":\"18622927505\",\"flag\":\"1\"}");

//			// 广告咨询获取
//			put("getTopic",
//					"head={\"xyh\":\"0501\",\"ztm\":\"000\"}&body={\"type\":0,\"publishTime\":1438754367000,\"count\":5}");

			// 违章查询
			put("jdcViolateManage",
					"head={\"xyh\":\"0601\",\"ztm\":\"000\"}&body={\"hphm\":\"辽DR6368\",\"hpzl\":\"02\",\"fdjh\":\"005754\"}");
//
//			// 驾驶证查询
			put("drivingLicenseManage",
					"head={\"xyh\":\"0401\",\"ztm\":\"000\"}&body={\"sfzmhm\":\"350203197205014123\",\"dabh\":\"350200144822\",\"xm\":\"庄\"}");
//
////			// 机动车查询D5N536
			put("queryJdcManage",
					"head={\"xyh\":\"0301\",\"ztm\":\"000\"}&body={\"hphm\":\"DR6368\",\"hpzl\":\"02\",\"fdjh\":\"005754\"}");
//
//			// 绑定机动车
//			put("boundUserVehicle", "username=&hphm=&hpzl=&fdjh=");
//
//			// 绑定驾驶证
			put("boundUserDriverLicense",
					"head={\"xyh\":\"0402\",\"ztm\":\"000\"}&body={\"username\":\"18622927505\",\"sfzmhm\":\"350203197205014123\",\"dabh\":\"350200144822\",\"xm\":\"庄\"}");
//			
//			// 绑定驾驶证
			put("unboundUserDriverLicense",
					"head={\"xyh\":\"0403\",\"ztm\":\"000\"}&body={\"username\":\"18622927505\",\"sfzmhm\":\"350203197205014123\"}");
//			
//			// 绑定驾驶证
			put("queryBoundUserDriverLicense",
					"head={\"xyh\":\"0404\",\"ztm\":\"000\"}&body={\"username\":\"18622927505\"}");
		}
	};

	public static void main(String[] args) throws Exception {

		// StringBuffer url = new StringBuffer(
		// "https://sso.ehualu.com:8443/ehualu-appServer/handle.json");

		StringBuffer url = new StringBuffer(
				"https://127.0.0.1:8443/ehualu-appServer/handle.json");
//		 StringBuffer url = new StringBuffer(
//		 "http://114.247.102.206:8070/ehualu-appServer/handle.json");

		String sessionId = "JSESSIONID=2A4D10F0F01DCBF57775284928483A42;";

		String param = (String) paramMap.get("unboundUserDriverLicense");

		String resp = connectHttpsUri(url.toString(), param,sessionId);

		// System.out.print(errorcode.ERROR001.translate());
	}

	public static String connectHttpsUri(String uri, String param,
			String sessionId) {
		// 这是密钥库
		String sslKeyStorePath = "D:\\keys\\client.p12";

		String sslKeyStorePassword = "123456";

		String sslKeyStoreType = "PKCS12"; // 密钥库类型，有JKS PKCS12等
		// 信任库，这里需要服务端来新人客户端才能调用，因为这个我是配置的https双向验证，不但是要客户端信任服务端，服务端也要信任客户端。

		String sslTrustStore = "D:\\keys\\client.truststore";

		String sslTrustStorePassword = "123456";

		System.setProperty("javax.net.ssl.keyStoreType", sslKeyStoreType);

		System.setProperty("javax.net.ssl.keyStore", sslKeyStorePath);

		System.setProperty("javax.net.ssl.keyStorePassword",

		sslKeyStorePassword);

		// 设置系统参数
		System.setProperty("javax.net.ssl.trustStoreType", "BKS");

		System.setProperty("javax.net.ssl.trustStore", sslTrustStore);

		System.setProperty("javax.net.ssl.trustStorePassword",
				sslTrustStorePassword);

		System.setProperty("java.protocol.handler.pkgs", "sun.net.www.protocol");

		StringBuffer sb = new StringBuffer();
		try {
			URL finalurl = new URL(uri);
			HttpsURLConnection connection = (HttpsURLConnection) finalurl
					.openConnection();
			if (sessionId != null && !"".equals(sessionId)) {
				connection.setRequestProperty("Cookie", sessionId);
			}
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
					"application/x-www-form-urlencoded");
			connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
			connection.connect();
			// POST请求
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.write(param.getBytes("utf-8"));
			out.flush();
			out.close();
			String cookieVal = "";
			String key = "";
			for (int i = 1; (key = connection.getHeaderFieldKey(i)) != null; i++) {
				if (key.equalsIgnoreCase("set-cookie")) {
					cookieVal = connection.getHeaderField(i);
					cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
					sessionId = sessionId + cookieVal + ";";
				}
			}
			System.out.println(sessionId);
			System.out.println("--debug myurl:" + uri + ",length:"
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
		System.out.println("---result:" + sb.toString() + "---------------");
		return sb.toString();
	}

	public static String connectHttpUri(String uri, String param) {
		StringBuffer sb = new StringBuffer();
		try {
			URL finalurl = new URL(uri);
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
					"application/x-www-form-urlencoded");
			connection.connect();

			// POST请求
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.write(param.getBytes("utf-8"));
			out.flush();
			out.close();

			System.out.println("--debug myurl:" + uri + ",length:"
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
		System.out.println("---result:" + sb.toString() + "---------------");
		return sb.toString();
	}

}
