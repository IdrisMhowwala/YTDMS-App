package com.yash.ytdms.serviceimpl;

import java.util.List;

import com.yash.ytdms.dao.TestDAO;
import com.yash.ytdms.daoimpl.TestDAOImpl;
import com.yash.ytdms.domain.Test;
import com.yash.ytdms.exception.TestException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.TestService;
import com.yash.ytdms.util.ValidationUtil;

public class TestServiceImpl implements TestService {

	private TestDAO testDAO = null;

	public TestServiceImpl() {
		testDAO = (TestDAO) ObjectFactory.getObject(TestDAO.class);
	}

	@Override
	public void createTest(Test test) throws TestException {
		if (ValidationUtil.validateLength(test.getName(),5)) {
			throw new TestException("Test name must be between 2 and 5 characters");
		} else {
			testDAO.save(test);
		}
	}

	@Override
	public void removeTest(Test test) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editTestDetail(Test test) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Test> getAllTests() {
		// TODO Auto-generated method stub
		return null;
	}

}
