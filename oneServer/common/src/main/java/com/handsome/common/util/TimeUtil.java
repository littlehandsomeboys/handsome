package com.handsome.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil
{

	public TimeUtil()
	{
		// TODO Auto-generated constructor stub
	}

	public static String getTimeStamp()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);	
	}
	
}
