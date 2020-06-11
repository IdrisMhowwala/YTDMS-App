/**
 * 
 */
package com.yash.ytdms.exception;

/**
 *  This GroupStatusException is used for throwing custom exception related to GroupStatus
 * @author ritik.maheshwari
 *
 */
public class GroupStatusException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is GroupStatusException without msg
	 */
	public GroupStatusException(){
		super();
	}
	/**
	 * This is GroupStatusException with msg
	 * @param msg
	 */
	public GroupStatusException(String errormsg) {
		super(errormsg);
	}
}
