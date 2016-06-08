package com.ehualu.rise.property;

import java.io.InputStream;
import java.util.Properties;

public class CertConfig {
	
	private static String default_config = "/security/security.properties";

	private static Properties config;
	static
	{
		config = new Properties();

		try
		{

			Class<?> config_class = Class.forName(PropertyConfig.class.getName());

			InputStream is = config_class.getResourceAsStream(default_config);
			config.load(is);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getAlias(){
		return config.getProperty("alias").toString();
	}
	
	public static  String getCertificatePath(){
		return config.getProperty("certificatePath").toString();
	}
	
	public static String getKeyStorePath(){
		return config.getProperty("keyStorePath").toString();
	}
	
	public static String getPassword(){
		return config.getProperty("password").toString();
	}
}
