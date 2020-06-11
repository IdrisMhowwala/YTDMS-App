package com.yash.ytdms.exception;

/**
 * This DocumentException is used for throwing custom exception related to Document
 * @author samay.jain
 *
 */
public class DocumentException extends Exception {
	
	/**
	 * This creates the DocumentException object without error message
	 */
	public DocumentException()
	{
		super();
	}
	
	/**
	 *  This creates the DocumentException object with error message
	 * @param errMsg
	 */
	public DocumentException(String errMsg)
	{
		super(errMsg);
	}
}
