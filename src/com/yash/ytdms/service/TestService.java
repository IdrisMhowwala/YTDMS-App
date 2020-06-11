package com.yash.ytdms.service;

import java.util.List;

import com.yash.ytdms.domain.Test;
import com.yash.ytdms.exception.TestException;

/**
 * This TestService interface will be performing business service on Test
 * 
 * @author samay.jain
 *
 */
public interface TestService {

	void createTest(Test test) throws TestException;

	void removeTest(Test test);

	void editTestDetail(Test test);

	List<Test> getAllTests();

}
