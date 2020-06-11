package com.yash.ytdms.exception;

public class GroupException extends Exception {
	/**
	 * This creates the GroupException object without error message
	 */
	public GroupException() {
		super();
	}
	/**
	 * This creates the GroupException object without error message
	 * @param errMsg
	 */
	public GroupException(String errMsg) {
		super(errMsg);
	}
}
