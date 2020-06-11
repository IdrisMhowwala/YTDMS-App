package com.yash.ytdms.test;

import com.yash.ytdms.dao.TestDAO;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.TestService;
import com.yash.ytdms.serviceimpl.TestServiceImpl;

public class ObjectFetchTest {

	public static void main(String[] args) {
		TestDAO testDAO = (TestDAO)ObjectFactory.getObject(TestDAO.class);
		System.out.println(testDAO);
	}

}
