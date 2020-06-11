package com.yash.ytdms.dao;

import java.util.List;

import com.yash.ytdms.domain.Test;

/**
 * This TestDAO will perform all the CRUD operations related to Test
 * 
 * @author samay.jain
 *
 */
public interface TestDAO {

	/**
	 * This save method will save the test in testtable
	 * 
	 * @param test to be saved
	 */
	void save(Test test);

	/**
	 * This update method will update the test in testtable.
	 * 
	 * @param test to be updated
	 */
	void update(Test test);

	/**
	 * This delete method will delete the test from the testtable
	 * 
	 * @param test to be deleted
	 */
	void delete(Test test);

	/**
	 * This delete method will delete the test from the testtable based on provided
	 * id
	 * 
	 * @param id of the test to be deleted.
	 */
	void delete(int id);

	/**
	 * This findAll method will return the list of all the tests available in
	 * testtable
	 * 
	 * @return
	 */
	List<Test> findAll();

}
