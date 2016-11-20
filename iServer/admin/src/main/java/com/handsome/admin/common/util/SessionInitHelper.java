package com.handsome.admin.common.util;

import javax.servlet.http.HttpSession;

public class SessionInitHelper
{

	public SessionInitHelper()
	{

	}

	public static void setSessionAttribute(HttpSession session,String key,Object value)
	{
		session.setAttribute(key,value);
	}
	
	public static Object getSessionAttribute(HttpSession session,String key)
	{
		return session.getAttribute(key);
	}
}
