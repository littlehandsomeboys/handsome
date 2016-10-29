package com.handsome.admin.common.util;

import javax.servlet.http.HttpSession;

import com.handsome.admin.constent.SessionKeyConstent;
import com.handsome.siteuser.api.bean.SiteUser;

public class SessionInitHelper
{

	public SessionInitHelper()
	{

	}

	public static void setSession(HttpSession session, SiteUser su)
	{
		session.setAttribute(SessionKeyConstent.SESSION_KEY_OBJ_USER_BEAN, su);
	}
}
