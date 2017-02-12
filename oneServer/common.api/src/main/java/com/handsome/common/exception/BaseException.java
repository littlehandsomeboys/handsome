package com.handsome.common.exception;

public class BaseException extends Exception
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public BaseException(Exception e)
	{
		super.addSuppressed(e);
	}

}
