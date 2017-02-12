package com.handsome.common.util;

import java.util.UUID;

public class UUIDTool
{

	public UUIDTool()
	{
		// TODO Auto-generated constructor stub
	}

	static public String getUUID32()
	{
		return UUID.randomUUID().toString().replace("-", "");
	}
}
