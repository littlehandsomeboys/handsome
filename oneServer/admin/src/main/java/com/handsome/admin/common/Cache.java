package com.handsome.admin.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache
{

	private static Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

	private static Cache instance = new Cache();

	private Cache()
	{

		if (null == instance)
		{
			instance = new Cache();
		}
		if (null == cache)
		{
			cache = new ConcurrentHashMap<String, Object>();
		}

	}

	public static Cache getInstance()
	{
		return instance;
	}

	public Object getObj(String key)
	{
		return cache;
	}
	
	public void setObj(String key, Object obj)
	{
		cache.put(key, obj);
	}
}
