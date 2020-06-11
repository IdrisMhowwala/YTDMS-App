package com.yash.ytdms.exception;

/**
 * This TestException is used for throwing custom exception related to Test
 * @author samay.jain
 *
 */
public class TestException extends Exception {

	/**
	 * This creates the TestException object without error message
	 */
	public TestException() {
		super();
	}

	/**
	 * This creates the TestException object with error message
	 */
	public TestException(String errMsg) {
		super(errMsg);
	}

}
