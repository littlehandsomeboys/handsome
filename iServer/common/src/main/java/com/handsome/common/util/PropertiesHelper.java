package com.handsome.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper
{
	private static final String file = "config.properties";

	private static Properties dbProps = new Properties();

	static
	{
		init();
	}

	private PropertiesHelper()
	{
		init();
	}

	public static void init()
	{
		InputStream inputStream = null;
		try
		{
			inputStream = PropertiesHelper.class
					.getResourceAsStream("/" + file);
			dbProps.load(inputStream);
			// if (inputStream == null)
			// {
			// inputStream = ClassLoader.getResourceAsStream(file);
			// }
			// ServletContext. getResourceAsStream(file);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (null != inputStream)
				{
					inputStream.close();
				}
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static String getProperties(String key)
	{
		return dbProps.getProperty(key);
	}

	public static String getProperties(String key, String defaultValue)
	{
		return dbProps.getProperty(key, defaultValue);
	}

}
