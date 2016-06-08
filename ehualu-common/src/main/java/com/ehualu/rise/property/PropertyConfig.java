package com.ehualu.rise.property;

import java.io.InputStream;
import java.util.Properties;

/**
 * 读取资源文件
 * @author Administrator
 *
 */
public class PropertyConfig
{
	private static String default_config = "/message/message_zh_CN.properties";

	private static Properties mConfig;
	static
	{
		mConfig = new Properties();

		try
		{

			Class<?> config_class = Class.forName(PropertyConfig.class.getName());

			InputStream is = config_class.getResourceAsStream(default_config);
			mConfig.load(is);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String getProperty(String key)
	{
		return mConfig.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue)
	{
		String value = mConfig.getProperty(key);
		if (value == null)
			return defaultValue;

		return value;
	}

	public static boolean getBooleanProperty(String name, boolean defaultValue)
	{
		String value = PropertyConfig.getProperty(name);

		if (value == null)
			return defaultValue;

		return (new Boolean(value)).booleanValue();
	}

	public static int getIntProperty(String name)
	{
		return getIntProperty(name, 0);
	}

	public static int getIntProperty(String name, int defaultValue)
	{
		String value = PropertyConfig.getProperty(name);

		if (value == null)
			return defaultValue;

		return (new Integer(value)).intValue();
	}
}
