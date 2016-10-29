package com.handsome.admin.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.handsome.admin.common.Cache;

public class SessionListener implements HttpSessionListener
{
	@Override
	public void sessionCreated(HttpSessionEvent event)
	{
		HttpSession ses = event.getSession();
		String id = ses.getId() + ses.getCreationTime();
//		Cache cache = Cache.getInstance();
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event)
	{
		HttpSession ses = event.getSession();
		String id = ses.getId() + ses.getCreationTime();
		synchronized (this)
		{
		}
	}
}
